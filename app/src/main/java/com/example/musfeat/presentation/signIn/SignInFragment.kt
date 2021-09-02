package com.example.musfeat.presentation.signIn

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.musfeat.R
import com.example.musfeat.databinding.FragmentSignInBinding
import com.example.musfeat.domain.entities.result.SignInResult
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel by viewModels<SignInViewModel>()
    private val emailText get() = binding.tilLogin.editText?.text.toString()
    private val passwordText get() = binding.tilPassword.editText?.text.toString()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        val view = binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.signInResult.observe(viewLifecycleOwner) { signInResult ->
            when (signInResult) {
                SignInResult.Initial -> {
                    Log.d(
                        javaClass.simpleName,
                        "onViewCreated: signIn livedata is in initial state "
                    )
                }
                SignInResult.Loading -> isLoadingShown(true)
                SignInResult.Success -> {
                    isLoadingShown(false)
                    findNavController().navigate(R.id.action_signInFragment_to_cardFragment)

                }
                SignInResult.Error -> {
                    isLoadingShown(false)
                    Snackbar.make(binding.root, "Ну ебать ты лох , братишка", Snackbar.LENGTH_SHORT)
                        .show()
                }
            }
        }

        binding.btLogin.setOnClickListener {
            viewModel.login(emailText, passwordText)
        }

        with(binding.tilLogin) {
            editText?.doAfterTextChanged {
                isErrorEnabled = !viewModel.isEmailValid(emailText)
                when {
                    isErrorEnabled && emailText.isNotBlank() -> error =
                        getString(R.string.email_error_text)
                    isErrorEnabled && emailText.isBlank() -> error =
                        getString(R.string.empty_field_error_text)
                }
            }
        }

        with(binding.tilPassword) {
            editText?.doAfterTextChanged {
                isErrorEnabled = !viewModel.isPasswordValid(passwordText)
                when {
                    isErrorEnabled && passwordText.isNotBlank() -> error =
                        getString(R.string.password_error_text)
                    isErrorEnabled && passwordText.isBlank() -> error =
                        getString(R.string.empty_field_error_text)
                }
            }
        }
    }

    private fun isLoadingShown(isShown: Boolean) {
        binding.pbLoading.isVisible = isShown
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}