package com.syntax_institut.whatssyntax

import android.app.Application
import android.telecom.Call
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.syntax_institut.whatssyntax.data.Repository
import com.syntax_institut.whatssyntax.model.Calls
import com.syntax_institut.whatssyntax.model.Chats
import com.syntax_institut.whatssyntax.model.Contact
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository()
    val chatsList = repository.chatsList

    val contactList = repository.contactList

    val status = repository.statusImage

    private var _currentList = MutableLiveData<List<Chats>>()
    var currentList: LiveData<List<Chats>> = _currentList

    private var _currentContact = MutableLiveData<Contact> ()
    var currentContact: LiveData<Contact> = _currentContact

    private var _currentCall = MutableLiveData<List<Calls>>()
    var currentCall: LiveData<List<Calls>> = _currentCall

    init {
        loadChatsList()
        loadContactList()
    }

    fun loadChatsList() {
        viewModelScope.launch {
            repository.loadChats()
        }
    }

    fun loadContactList() {
        viewModelScope.launch {
            repository.loadContactList()
        }
    }

    fun getCurrentContact (selectedContact: Contact) {
        _currentContact.postValue(selectedContact)
    }

}