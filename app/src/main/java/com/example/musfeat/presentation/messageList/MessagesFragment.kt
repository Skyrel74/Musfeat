package com.example.musfeat.presentation.messageList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.musfeat.databinding.FragmentMessageListBinding

class MessagesFragment : Fragment() {
    private var _bindind: FragmentMessageListBinding? = null
    private val binding get() = requireNotNull(_bindind)
    private val viewModel by viewModels<MessagesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bindind = FragmentMessageListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        _bindind = null
        super.onDestroyView()
    }
}