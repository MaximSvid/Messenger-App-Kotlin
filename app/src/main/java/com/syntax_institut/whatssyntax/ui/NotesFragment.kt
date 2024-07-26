package com.syntax_institut.whatssyntax.ui

import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.syntax_institut.whatssyntax.MainViewModel
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.adapter.NotesAdapter
import com.syntax_institut.whatssyntax.databinding.FragmentNotesBinding
import com.syntax_institut.whatssyntax.model.NotesData

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
            context?.let { it1 -> showAlertDialog(it1) }
        }



    }

    private fun showAlertDialog(context: Context) {
        val dialogBuilder = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.alert_dialog_new_note, null)
        dialogBuilder.setView(dialogView)

        val name = dialogView.findViewById<EditText>(R.id.alert_titel)
        val message = dialogView.findViewById<EditText>(R.id.alert_descr)

        dialogBuilder.setTitle("Add Note")

        dialogBuilder.setPositiveButton("Save") { _, _ -> }

        dialogBuilder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        val alertDialog = dialogBuilder.create()
        alertDialog.show()


        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
            val nameText = name.text.toString()
            val messageText = message.text.toString()

            if (nameText.isBlank() || messageText.isBlank()) {
                Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                val updateNote = NotesData(
                    name = nameText,
                    text = messageText
                )

                viewModel.addNote(updateNote)
                alertDialog.dismiss()
            }
        }
    }


//    private fun showAlertDialog(context: Context) {
//       val dialogBuilder = context?.let { AlertDialog.Builder(it) }
//        val inflater = LayoutInflater.from(context)
//        val dialogView = inflater.inflate(R.layout.alert_dialog_new_note, null)
//        if (dialogBuilder != null) {
//            dialogBuilder.setView(dialogView)
//        }
//
//        val name = dialogView.findViewById<EditText>(R.id.alert_titel)
//        val message = dialogView.findViewById<EditText>(R.id.alert_descr)
//
//        if (dialogBuilder != null) {
//            dialogBuilder.setTitle("Add Note")
//
//            dialogBuilder.setPositiveButton("Save") { _, _ ->
//                val updateNote = NotesData(
//                    name = name.text.toString(),
//                    text = message.text.toString()
//                )
//                viewModel.addNote(updateNote)
//
//            }
//
//            dialogBuilder.setNegativeButton("Cancel") {dialog, _ ->
//                dialog.dismiss()
//            }
//            val alertDialog = dialogBuilder.create()
//            alertDialog.show()
//        }
//    }

}