package com.example.kabaddicounter.ui.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {

    private val _scoreA = MutableLiveData<Int>(0)
    val scoreA: LiveData<Int>
        get() = _scoreA

    private val _scoreB = MutableLiveData(0)
    val scoreB: LiveData<Int> get() = _scoreB

    fun incrementScore(isTeamA: Boolean) {
        if (isTeamA) {
            _scoreA.value = _scoreA.value!! + 1
        }
        else {
            _scoreB.value = (_scoreB.value ?: 0) + 1
        }
    }

    fun incrementTwoScore(isTeamA: Boolean) {
        if (isTeamA) {
            _scoreA.value = (_scoreA.value ?: 0) + 2
        } else {
            _scoreB.value = (_scoreB.value ?: 0) + 2
        }
    }

    fun resetScores() {
        _scoreA.value = 0
        _scoreB.value = 0
    }
}