package com.syntax_institut.whatssyntax.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.syntax_institut.whatssyntax.MainViewModel
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.databinding.FragmentSettingsBinding
import com.syntax_institut.whatssyntax.model.Profile

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(layoutInflater)
        viewModel.loadProfile()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.profile.observe(viewLifecycleOwner) {
            val profileImage = viewModel.profile.value?.image ?: R.drawable.pp_01
            binding.ivProfile.load(profileImage)

            val profileName = viewModel.profile.value?.name ?: "Test Name"
            binding.tietProfileName.setText(profileName)

            val profileNumber = viewModel.profile.value?.number ?: "1234"
            binding.tietProfileNumber.setText(profileNumber)
        }

        binding.btProfileSave.setOnClickListener {

            if (binding.tietProfileName.text.toString().isNotEmpty() == true && binding.tietProfileNumber.text.toString().isNotEmpty() == true) {
                val updateName = binding.tietProfileName.text.toString()
                val updatePhoneNumber = binding.tietProfileNumber.text.toString()
                val updateImage = viewModel.profile.value?.image.toString()
//                val updateProfile: Profile = Profile(updateName, updatePhoneNumber, updateImage)
                viewModel.updateProfile(updateName, updatePhoneNumber, updateImage)
            } else {
                Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }





        }





    }
}