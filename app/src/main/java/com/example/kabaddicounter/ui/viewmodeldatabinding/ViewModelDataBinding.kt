package com.example.kabaddicounter.ui.viewmodeldatabinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.kabaddicounter.R
import com.example.kabaddicounter.databinding.ActivityMainBinding
import com.example.kabaddicounter.databinding.FragmentViewModelDataBindingBinding
import com.example.kabaddicounter.ui.livedatawithbind.ScoreViewModel

class ViewModelDataBinding : Fragment() {
    private val viewModel : ScoreViewModel by viewModels()
    private lateinit var binding: FragmentViewModelDataBindingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_view_model_data_binding, container, false
        )

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        setupClickListeners()

        return binding.root
    }

    private fun setupClickListeners() {
        binding.plusOneButtonA.setOnClickListener {
            viewModel.incrementScore(true)
        }

        binding.plusTwoButtonA.setOnClickListener {
            viewModel.incrementTwoScore(true)
        }

        binding.plusOneButtonB.setOnClickListener {
            viewModel.incrementScore(false)
        }

        binding.plusTwoButtonB.setOnClickListener {
            viewModel.incrementTwoScore(false)
        }

        binding.reset.setOnClickListener {
            viewModel.resetScores()
        }
    }
}