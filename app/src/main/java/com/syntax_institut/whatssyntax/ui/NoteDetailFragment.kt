package com.syntax_institut.whatssyntax.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.databinding.FragmentNoteDetailBinding


class NoteDetailFragment : Fragment() {
    private lateinit var binding: FragmentNoteDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteDetailBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
}

