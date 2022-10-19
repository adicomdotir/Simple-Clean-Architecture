package com.example.simplecleanarchitecture.data

import com.example.simplecleanarchitecture.data.database.dao.QuoteDao
import com.example.simplecleanarchitecture.data.database.entities.QuoteEntity
import com.example.simplecleanarchitecture.data.model.QuoteModel
import com.example.simplecleanarchitecture.data.network.QuoteService
import com.example.simplecleanarchitecture.domain.model.Quote
import com.example.simplecleanarchitecture.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {
    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}