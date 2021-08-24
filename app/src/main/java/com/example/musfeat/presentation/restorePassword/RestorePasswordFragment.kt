package com.example.musfeat.presentation.restorePassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.musfeat.databinding.FragmentRestorePasswordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestorePasswordFragment : Fragment() {
    private var _binding :FragmentRestorePasswordBinding? = null
    private val binding : FragmentRestorePasswordBinding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRestorePasswordBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        _binding=null
        super.onDestroyView()
    }
}

