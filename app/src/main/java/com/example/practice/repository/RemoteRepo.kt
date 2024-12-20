package com.example.practice.repository

import com.example.practice.models.Quote
import com.example.practice.services.ApiService
import retrofit2.Response
import javax.inject.Inject

class RemoteRepo @Inject constructor (private val apiService: ApiService) {

    suspend fun getQuoteList():Response<Quote>{
        return apiService.getApiData()
    }
}