package com.example.kabaddicounter.ui.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.example.kabaddicounter.R

class ScoreVMFragment : Fragment() {
    val viewModel: ScoreViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_score_v_m, container, false)

        val scoreViewA: TextView = view.findViewById(R.id.scoreA)
        val scoreViewB: TextView = view.findViewById(R.id.scoreB)

        val plusOneButtonA: Button = view.findViewById(R.id.plusOneButtonA)
        val plusOneButtonB: Button = view.findViewById(R.id.plusOneButtonB)
        val plusTwoButtonA: Button = view.findViewById(R.id.plusTwoButtonA)
        val plusTwoButtonB: Button = view.findViewById(R.id.plusTwoButtonB)
        val reset : Button = view.findViewById(R.id.reset)

        scoreViewA.text = viewModel.scoreA.toString()

        plusOneButtonA.setOnClickListener{
            viewModel.incrementScore(true)
            scoreViewA.text = viewModel.scoreA.toString()
        }

        plusOneButtonB.setOnClickListener{
            viewModel.incrementScore(false)
            scoreViewB.text = viewModel.scoreB.toString()
        }

        plusTwoButtonA.setOnClickListener{
            viewModel.incrementTwoScore(true)
            scoreViewA.text = viewModel.scoreA.toString()
        }

        plusTwoButtonB.setOnClickListener{
            viewModel.incrementTwoScore(false)
            scoreViewB.text = viewModel.scoreB.toString()
        }

            reset.setOnClickListener{
                viewModel.reset()
                scoreViewA.text = viewModel.scoreA.toString()
                scoreViewB.text = viewModel.scoreB.toString()
            }

        return view
    }
}