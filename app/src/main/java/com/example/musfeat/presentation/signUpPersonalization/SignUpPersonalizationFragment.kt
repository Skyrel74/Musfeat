package com.example.musfeat.presentation.signUpPersonalization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.musfeat.databinding.FragmentSignUpPersonalizationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpPersonalizationFragment : Fragment() {
    private var _binding: FragmentSignUpPersonalizationBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel by viewModels<SignUpPersonalizationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpPersonalizationBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}