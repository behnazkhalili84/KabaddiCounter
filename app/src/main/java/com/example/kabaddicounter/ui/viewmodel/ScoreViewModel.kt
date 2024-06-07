package com.example.kabaddicounter.ui.viewmodel

import androidx.lifecycle.ViewModel

class ScoreViewModel  : ViewModel() {
    var scoreA : Int = 0
    var scoreB : Int = 0
    fun incrementScore(isTeamA: Boolean) {
        if (isTeamA) {
            scoreA++
        }
        else {
            scoreB++
        }
    }

    fun incrementTwoScore(isTeamA: Boolean) {
        if (isTeamA) {
            scoreA += 2
        }
        else {
            scoreB += 2
        }
    }

    fun reset( ){
        scoreA = 0
        scoreB = 0
    }
}