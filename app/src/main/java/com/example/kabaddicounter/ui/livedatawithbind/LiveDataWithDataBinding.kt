package com.example.kabaddicounter.ui.livedatawithbind

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.kabaddicounter.R
import com.example.kabaddicounter.databinding.FragmentLiveDataBinding
import com.example.kabaddicounter.databinding.FragmentLiveDataWithDataBindingBinding
import com.example.kabaddicounter.databinding.FragmentViewModelDataBindingBinding


class LiveDataWithDataBinding: Fragment() {
    private val viewModel:ScoreViewModel by viewModels()
    private lateinit var binding: FragmentLiveDataWithDataBindingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_live_data_with_data_binding,container,false)

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