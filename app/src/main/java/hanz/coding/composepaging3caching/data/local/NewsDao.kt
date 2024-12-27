package hanz.coding.composepaging3caching.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface NewsDao {

    @Upsert
    suspend fun upsertAll(newsEntity: List<NewsEntity>)

    @Query("DELETE FROM NewsEntity")
    suspend fun clearAll()

    @Query("SELECT * FROM NewsEntity")
    fun pagingSource(): PagingSource<Int, NewsEntity>
}