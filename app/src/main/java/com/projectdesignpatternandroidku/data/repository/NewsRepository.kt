package com.projectdesignpatternandroidku.data.repository

import com.projectdesignpatternandroidku.data.model.ActionState
import com.projectdesignpatternandroidku.data.model.News
import com.projectdesignpatternandroidku.data.remote.NewsService
import com.projectdesignpatternandroidku.data.remote.RetrofitApi
import retrofit2.await
import retrofit2.http.Query
import java.lang.Exception

class NewsRepository {
    private val newsService : NewsService by lazy { RetrofitApi.newsService() }

    suspend fun listNews() : ActionState<List<News>>{
        return try {
            val list = newsService.listNews().await()
            ActionState(list.data)
        }catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailNews(url: String) : ActionState<News>{
        return try {
            val  list = newsService.detailNews(url).await()
            ActionState(list.data.first())
        }catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchNews(query: String) : ActionState<List<News>>{
        return try {
            val  list = newsService.searchNews(query).await()
            ActionState(list.data)
        }catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }
}