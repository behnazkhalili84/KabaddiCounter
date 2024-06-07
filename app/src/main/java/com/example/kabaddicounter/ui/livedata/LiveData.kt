package com.example.kabaddicounter.ui.livedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.kabaddicounter.R
import com.example.kabaddicounter.databinding.FragmentLiveDataBinding
import com.example.kabaddicounter.databinding.FragmentViewModelDataBindingBinding


class LiveData: Fragment() {
    private val viewModel: ScoreViewModel by viewModels()
    private lateinit var scoreViewA: TextView
    private lateinit var scoreViewB: TextView
    private lateinit var plusOneButtonA: Button
    private lateinit var plusTwoButtonA: Button
    private lateinit var plusOneButtonB: Button
    private lateinit var plusTwoButtonB: Button
    private lateinit var resetButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_live_data, container, false)

        scoreViewA = view.findViewById(R.id.scoreViewA)
        scoreViewB = view.findViewById(R.id.scoreViewB)
        plusOneButtonA = view.findViewById(R.id.plusOneButtonA)
        plusTwoButtonA = view.findViewById(R.id.plusTwoButtonA)
        plusOneButtonB = view.findViewById(R.id.plusOneButtonB)
        plusTwoButtonB = view.findViewById(R.id.plusTwoButtonB)
        resetButton = view.findViewById(R.id.reset)

        setupClickListeners()
        setupObservers()

        return view
    }

    private fun setupClickListeners() {
        plusOneButtonA.setOnClickListener {
            viewModel.incrementScore(true)
        }

        plusTwoButtonA.setOnClickListener {
            viewModel.incrementTwoScore(true)
        }

        plusOneButtonB.setOnClickListener {
            viewModel.incrementScore(false)
        }

        plusTwoButtonB.setOnClickListener {
            viewModel.incrementTwoScore(false)
        }

        resetButton.setOnClickListener {
            viewModel.resetScores()
        }
    }

    private fun setupObservers() {
        viewModel.scoreA.observe(viewLifecycleOwner, Observer { newScore ->
            scoreViewA.text = newScore.toString()
        })

        viewModel.scoreB.observe(viewLifecycleOwner, Observer { newScore ->
            scoreViewB.text = newScore.toString()
        })
    }
}