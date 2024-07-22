package com.syntax_institut.whatssyntax.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.syntax_institut.whatssyntax.MainViewModel
import com.syntax_institut.whatssyntax.adapter.StatusDetailAdapter
import com.syntax_institut.whatssyntax.databinding.FragmentStatusDetailBinding

class StatusDetailFragment: Fragment() {

    private lateinit var binding: FragmentStatusDetailBinding
    private val viewMode: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatusDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewMode.status.observe(viewLifecycleOwner) {
            binding.rvFragmentStatusDetail.adapter = StatusDetailAdapter(it, viewMode)

        }

        binding.btnBackStatusDetailFragment.setOnClickListener {
            findNavController().navigateUp()
        }

    }
}