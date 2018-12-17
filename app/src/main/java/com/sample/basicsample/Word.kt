package com.sample.basicsample

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private val word: String

    constructor(word: String) {
        this.word = word
    }

    fun getWord() = this.word
}
