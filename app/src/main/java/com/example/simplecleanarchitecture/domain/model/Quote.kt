package com.example.simplecleanarchitecture.domain.model

import com.example.simplecleanarchitecture.data.database.entities.QuoteEntity
import com.example.simplecleanarchitecture.data.model.QuoteModel

data class Quote (val quote:String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)