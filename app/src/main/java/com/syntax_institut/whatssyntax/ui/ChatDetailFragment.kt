package com.syntax_institut.whatssyntax.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.syntax_institut.whatssyntax.MainViewModel
import com.syntax_institut.whatssyntax.adapter.ChatDetailAdapter
import com.syntax_institut.whatssyntax.databinding.FragmentChatDetailBinding
import com.syntax_institut.whatssyntax.model.Message

class ChatDetailFragment: Fragment() {

    private lateinit var binding: FragmentChatDetailBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatDetailBinding.inflate(layoutInflater)
        viewModel.loadChatsMessage(viewModel.currentChat.value!!.id)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentChat = viewModel.currentChat
        val chatId: Int = currentChat.value!!.id

        viewModel.loadChatsMessage( chatId)


        viewModel.message.observe(viewLifecycleOwner) {
            binding.rvMessages.adapter = ChatDetailAdapter(it, viewModel)
            binding.rvMessages.scrollToPosition(viewModel.message.value!!.lastIndex)
        }

        binding.btSend.setOnClickListener {

            val messageText = binding.tietMessage.text.toString()

            if (messageText.isNotBlank()) {
                val newMessage = Message (messageText, false)
                viewModel.updateChatMessage(chatId, newMessage)
                viewModel.loadChatsMessage( chatId)

                binding.tietMessage.text?.clear()





            }

        }





    }
}