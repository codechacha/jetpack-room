package com.sample.basicsample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData



class WordViewModel : AndroidViewModel {
    private val repository: WordRepository
    private val allWords: LiveData<List<Word>>

    constructor(app: Application) : super(app) {
        repository = WordRepository(app)
        allWords = repository.getAllWords()
    }

    fun getAllWords(): LiveData<List<Word>> = allWords
    fun insert(word: Word) {
        repository.insert(word)
    }
}