package hanz.coding.composepaging3caching.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("posts")
    suspend fun getNews(
        @Query("_start") start: Int,
        @Query("_limit") limit: Int,
    ): List<NewsDto>

    companion object {
        val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }
}