package com.syntax_institut.whatssyntax.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.syntax_institut.whatssyntax.MainViewModel
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.databinding.FragmentSettingsBinding

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





    }
}