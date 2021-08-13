package com.example.musfeat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.musfeat.databinding.FragmentCardBinding

class TestFragment : Fragment(R.layout.fragment_card) {

    //TODO DELETE ME
    private var _binding: FragmentCardBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCardBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}