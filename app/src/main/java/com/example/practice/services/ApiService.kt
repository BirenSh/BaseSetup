package com.example.practice.services

import com.example.practice.models.Quote
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("quotes")
    suspend fun getApiData():Response<Quote>
}