package com.example.musfeat.presentation.dialog

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.musfeat.R
import com.example.musfeat.databinding.FragmentDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DialogFragment : Fragment(R.layout.fragment_dialog) {
    private val binding by viewBinding(FragmentDialogBinding::bind)
}