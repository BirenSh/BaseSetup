package com.example.practice.view_modules

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practice.models.QuoteX
import com.example.practice.repository.RemoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val remoteRepo: RemoteRepo) :ViewModel() {

    private val _listOfQuote = MutableLiveData<List<QuoteX>>()
    val listOfQuote:LiveData<List<QuoteX>>
        get() = _listOfQuote

    suspend fun getListOfQuote(){
        val quoteResponse = remoteRepo.getQuoteList()
        println("====size"+ quoteResponse.body()?.quotes?.size)
        if (quoteResponse.isSuccessful && quoteResponse.body() != null){
           _listOfQuote.postValue(quoteResponse.body()?.quotes)
        }
    }
}