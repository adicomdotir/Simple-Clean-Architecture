package com.example.simplecleanarchitecture.domain

import com.example.simplecleanarchitecture.data.QuoteRepository
import com.example.simplecleanarchitecture.data.database.entities.toDatabase
import com.example.simplecleanarchitecture.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke():List<Quote>{
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }
}