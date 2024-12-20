package com.example.practice.models

data class Quote(
    val limit: Int,
    val quotes: List<QuoteX>,
    val skip: Int,
    val total: Int
)