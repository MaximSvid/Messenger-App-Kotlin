package com.syntax_institut.whatssyntax.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.syntax_institut.whatssyntax.MainViewModel
import com.syntax_institut.whatssyntax.adapter.NotesAdapter
import com.syntax_institut.whatssyntax.databinding.FragmentNotesBinding

class NotesFragment: Fragment() {

    private lateinit var binding: FragmentNotesBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.noteList.observe(viewLifecycleOwner) {
            binding.rvNotes.adapter = NotesAdapter(it, viewModel)
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnNewNote.setOnClickListener {


            findNavController().navigate(NotesFragmentDirections.actionNotesFragmentToNewNoteFragment())
        }



    }

}