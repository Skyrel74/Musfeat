package com.example.musfeat.presentation.chat

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.musfeat.R
import com.example.musfeat.databinding.FragmentChatsListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatsFragment : Fragment(R.layout.fragment_chats_list) {
    private val binding by viewBinding(FragmentChatsListBinding::bind)
    private val viewModel by viewModels<ChatsViewModel>()
}