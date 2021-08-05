package com.example.musfeat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.example.musfeat.databinding.CardFragmentBinding

class TestFragment : Fragment(R.layout.card_fragment) {

    //TODO DELETE ME
    private var _binding: CardFragmentBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CardFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.settingSlidingPane.lockMode = SlidingPaneLayout.LOCK_MODE_UNLOCKED
        binding.settingSlidingPane.layoutMode = SlidingPaneLayout.LAYOUT_MODE_CLIP_BOUNDS
        binding.settingSlidingPane.layoutDirection = SlidingPaneLayout.LAYOUT_DIRECTION_LTR

        //todo swap to motion layout

        binding.ibSettingsClose.setOnClickListener {
            binding.settingSlidingPane.closePane()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.settingSlidingPane.closePane()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}