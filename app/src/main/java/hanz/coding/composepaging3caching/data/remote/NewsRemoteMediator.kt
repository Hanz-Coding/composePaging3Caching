package hanz.coding.composepaging3caching.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import coil.network.HttpException
import hanz.coding.composepaging3caching.data.local.NewsDatabase
import hanz.coding.composepaging3caching.data.local.NewsEntity
import hanz.coding.composepaging3caching.data.mappers.toEntity
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagingApi::class)
class NewsRemoteMediator(
    val newsApi: NewsApi,
    val newsDb: NewsDatabase
) : RemoteMediator<Int, NewsEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, NewsEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        lastItem.id + 1
                    }
                }
            }
            delay(2000L)
            val news = newsApi.getNews(
                start = loadKey,
                limit = state.config.pageSize
            )

            newsDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    newsDb.dao.clearAll()
                }
                val newsEntities = news.map { newDto ->
                    newDto.toEntity()
                }
                newsDb.dao.upsertAll(newsEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = news.isEmpty()
            )
        } catch (e: Exception) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}