package hanz.coding.composepaging3caching.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import hanz.coding.composepaging3caching.data.local.NewsDatabase
import hanz.coding.composepaging3caching.data.remote.NewsApi
import hanz.coding.composepaging3caching.data.remote.NewsRemoteMediator
import hanz.coding.composepaging3caching.presentation.NewsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@OptIn(ExperimentalPagingApi::class)
val appModule = module {
    single {
        Room.databaseBuilder(
            get(),
            NewsDatabase::class.java,
            "news_database"
        ).build()
    }

    single { get<NewsDatabase>().dao }

    single {
        Retrofit.Builder()
            .baseUrl(NewsApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(NewsApi::class.java)
    }

    single {
        Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = NewsRemoteMediator(
                newsDb = get<NewsDatabase>(),
                newsApi = get()
            ),
            pagingSourceFactory = { get<NewsDatabase>().dao.pagingSource() }
        )
    }

    viewModel { NewsViewModel(get()) }
}