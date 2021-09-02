package com.example.musfeat.presentation.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.musfeat.R
import com.example.musfeat.databinding.FragmentCardBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class CardFragment : Fragment() {
    private var _binding: FragmentCardBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel by viewModels<CardViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.constraintSettings.ibSettingsClose.setOnClickListener {
            binding.root.closeDrawer(GravityCompat.START)
        }
        // TODO: 02.09.2021 move getting and setting radius to viewmodel , handle initial state all the following code is stub for now
        binding.constraintSettings.tvSearchRadius.text =
            getString(R.string.search_settings_radius, 0)
        binding.constraintSettings.slSearchRange.addOnChangeListener { slider, value, fromUser ->
            val roundedValue = value.roundToInt()
            binding.constraintSettings.tvSearchRadius.text =
                getString(R.string.search_settings_radius, roundedValue)
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}