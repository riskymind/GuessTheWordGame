package com.example.guesstheword.screens.game

import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    var word = ""
    var score = 0

    private lateinit var wordList: MutableList<String>

    private fun resetList() {
        wordList = mutableListOf(
            "queen", "hospital", "basketball", "cat", "change", "snail", "soup", "calendar", "sad", "desk", "guitar",
            "home", "railway", "zebra", "jelly", "car", "crow", "trade", "bag", "roll", "bubble")
        wordList.shuffle()
    }

    private fun nextWord() {
        if (!wordList.isEmpty()) {
            word = wordList.removeAt(0)
        }
    }

    fun onSkip() {
        score--
        nextWord()
    }

    fun onCorrect() {
        score++
        nextWord()
    }

    init {
        resetList()
        nextWord()
    }
}