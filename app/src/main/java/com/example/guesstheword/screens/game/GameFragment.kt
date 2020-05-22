package com.example.guesstheword.screens.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.guesstheword.R
import com.example.guesstheword.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    private var word = ""

    private var score = 0

    private lateinit var wordList: MutableList<String>

    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)

        resetList()
        nextWord()

        binding.correctButton.setOnClickListener {
            onCorrect()
        }

        binding.skipButton.setOnClickListener {
            score--
            nextWord()
        }

        updateScoreText()
        updateWordText()

        return binding.root
    }

    private fun onCorrect() {
        score++
        nextWord()
    }

    private fun resetList() {
        wordList = mutableListOf("queen", "hospital", "basketball", "cat", "change", "snail", "soup", "calendar", "sad",
            "desk", "guitar", "home", "railway", "zebra", "jelly", "car", "crow", "trade", "bag", "roll", "bubble")

        wordList.shuffle()
    }

    private fun nextWord() {
        if (!wordList.isEmpty()) {
            word = wordList.removeAt(0)
        }
        updateWordText()
        updateScoreText()
    }

    private fun updateWordText() {
        binding.wordText.text = word
    }

    private fun updateScoreText() {
        binding.scoreText.text = score.toString()
    }


}
