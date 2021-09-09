package com.example.musfeat.presentation.signUpPersonalization

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.musfeat.R
import com.example.musfeat.databinding.FragmentSignUpPersonalizationBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.async

@AndroidEntryPoint
class SignUpPersonalizationFragment : Fragment(R.layout.fragment_sign_up_personalization) {
    private val binding by viewBinding(FragmentSignUpPersonalizationBinding::bind)
    private val viewModel by viewModels<SignUpPersonalizationViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val email = requireArguments().getString("email")
        val password = requireArguments().getString("password")

        setListeners()
    }

    private fun setListeners() {

        binding.ibAddAvatar.setOnClickListener {

        }



        binding.btnSignUp.setOnClickListener {
            //TODO(Progress bar start loading)
            val signUpJob = lifecycleScope.async {
                //viewModel.signUp()
                //TODO(Progress bar stop loading)
            }
        }
    }
}