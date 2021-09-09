package com.example.musfeat.presentation.signup

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.musfeat.R
import com.example.musfeat.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    private val binding by viewBinding(FragmentSignUpBinding::bind)
    private val viewModel by viewModels<SignUpViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTextChangeListeners()
        binding.btSubmit.setOnClickListener {
            if (!binding.tilName.isErrorEnabled
                && !binding.tilSurname.isErrorEnabled
                && !binding.tilEmail.isErrorEnabled
                && !binding.tilPassword.isErrorEnabled
                && !binding.tilPasswordRepeat.isErrorEnabled
            ) {
                val email: String = binding.tilEmail.editText!!.text.toString()
                val password: String = binding.tilPassword.editText!!.text.toString()
                val bundle: Bundle = bundleOf("email" to email, "password" to password)
                this.findNavController().navigate(R.id.signUpPersonalizationFragment, bundle)
            }
        }
    }

    private fun setTextChangeListeners() {
        binding.tilName.editText!!.doAfterTextChanged { name ->
            if (!viewModel.isNameValid(name.toString()))
                binding.tilName.editText!!.error = getString(R.string.name_error)
        }

        binding.tilSurname.editText!!.doAfterTextChanged { surname ->
            if (!viewModel.isSurnameValid(surname.toString()))
                binding.tilSurname.editText!!.error = getString(R.string.surname_error)
        }

        binding.tilEmail.editText!!.doAfterTextChanged { email ->
            if (!viewModel.isEmailValid(email.toString()))
                binding.tilEmail.editText!!.error = getString(R.string.email_error)
        }

        binding.tilPassword.editText!!.doAfterTextChanged { password ->
            if (!viewModel.isPasswordValid(password.toString()))
                binding.tilPassword.editText!!.error = getString(R.string.password_error)
        }

        binding.tilPasswordRepeat.editText!!.doAfterTextChanged { passwordRepeat ->
            if (!viewModel.isPasswordMatch(
                    binding.tilPassword.editText?.text.toString(),
                    passwordRepeat.toString()
                )
            )
                binding.tilPasswordRepeat.editText!!.error =
                    getString(R.string.passwordRepeat_error)
        }
    }
}