package com.example.kabaddicounter.ui.viewmodeldatabinding

import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    var scoreA = ObservableInt(0)
    var scoreB = ObservableInt(0)

    fun incrementScore(isTeamA: Boolean) {
        if (isTeamA) {
            scoreA.set(scoreA.get() + 1)
        } else {
            scoreB.set(scoreB.get() + 1)
        }
    }

    fun incrementTwoScore(isTeamA: Boolean) {
        if (isTeamA) {
            scoreA.set(scoreA.get() + 2)
        } else {
            scoreB.set(scoreB.get() + 2)
        }
    }

    fun resetScores() {
        scoreA.set(0)
        scoreB.set(0)
    }
}
