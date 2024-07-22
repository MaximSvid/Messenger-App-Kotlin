package com.syntax_institut.whatssyntax

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.syntax_institut.whatssyntax.data.Repository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository()
    val chatsList = repository.chatsList

    init {
        loadChatsList()
    }

    fun loadChatsList() {
        viewModelScope.launch {
            repository.loadChats()
        }
    }

}