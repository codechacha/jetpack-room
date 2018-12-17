package com.sample.basicsample

import android.app.Application
import androidx.lifecycle.LiveData
import android.os.AsyncTask

class WordRepository {

    companion object {
        private class insertAsyncTask constructor(private val asyncTaskDao: WordDao) :
                AsyncTask<Word, Void, Void>() {
            override fun doInBackground(vararg params: Word): Void? {
                asyncTaskDao.insert(params[0])
                return null
            }
        }
    }

    private val wordDao: WordDao
    private val allWords: LiveData<List<Word>>

    constructor(app: Application) {
        val db = WordRoomDatabase.getDatabase(app)
        wordDao = db.wordDao()
        allWords = wordDao.getAllwords()
    }

    fun getAllWords(): LiveData<List<Word>> {
        return allWords
    }

    fun insert(word: Word) {
        insertAsyncTask(wordDao).execute(word)
    }

}