package com.example.musfeat.presentation.cards

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.musfeat.R
import com.example.musfeat.databinding.FragmentCardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardFragment : Fragment(R.layout.fragment_card) {
    private val binding by viewBinding(FragmentCardBinding::bind)
    private val viewModel by viewModels<CardViewModel>()
}