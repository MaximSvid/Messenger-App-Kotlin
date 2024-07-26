package com.syntax_institut.whatssyntax.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.syntax_institut.whatssyntax.MainViewModel
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.databinding.FragmentNoteDetailBinding
import com.syntax_institut.whatssyntax.model.NotesData


class NoteDetailFragment : Fragment() {
    private lateinit var binding: FragmentNoteDetailBinding
    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteDetailBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedNote.observe(viewLifecycleOwner) {
            binding.etNoteName.setText(it.name)
            binding.etContent.setText(it.text)
        }

        binding.btnSave.setOnClickListener {
            val updateNote = NotesData (
                viewModel.selectedNote.value!!.id,
                binding.etNoteName.text.toString(),
                binding.etContent.text.toString()
            )
            viewModel.updateNote(updateNote)
            findNavController().navigateUp()
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}

