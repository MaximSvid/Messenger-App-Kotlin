package com.syntax_institut.whatssyntax

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.syntax_institut.whatssyntax.data.Repository
import com.syntax_institut.whatssyntax.data.local.getDatabase
import com.syntax_institut.whatssyntax.exampleData.NotesExampleData
import com.syntax_institut.whatssyntax.model.Calls
import com.syntax_institut.whatssyntax.model.Chats
import com.syntax_institut.whatssyntax.model.Contact
import com.syntax_institut.whatssyntax.model.Message
import com.syntax_institut.whatssyntax.model.Profile
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val repository = Repository(database)

    val noteList = repository.notesList
    val chatsList = repository.chatsList

    val contactList = repository.contactList

    val profile = repository.profile

    val calls = repository.callList

    val message = repository.messageList

    private var _currentChat = MutableLiveData<Chats>()
    var currentChat: LiveData<Chats> = _currentChat

    private var _currentContact = MutableLiveData<Contact> ()
    var currentContact: LiveData<Contact> = _currentContact

    private var _currentCall = MutableLiveData<List<Calls>>()
    var currentCall: LiveData<List<Calls>> = _currentCall

    private var _message = MutableLiveData<Message>()




    init {
        loadChatsList()
        loadContactList()
        loadProfile()
        loadCalls()

        insertNotesList()

    }

    fun insertNotesList () {
        viewModelScope.launch {
            val notes = listOf(
                NotesExampleData.test1,
                NotesExampleData.test2,
                NotesExampleData.test3,
                NotesExampleData.test4,
                NotesExampleData.test5,
                NotesExampleData.test6,
                NotesExampleData.test7,
                NotesExampleData.test8,
                NotesExampleData.test9,
                NotesExampleData.test10
            )
            repository.insertAll(notes)
        }
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

    fun loadProfile () {
        viewModelScope.launch {
            repository.loadProfile()
        }
    }

    fun updateProfile(name: String, number: String, image: String) {
        viewModelScope.launch {
            val profile = Profile(name, number, image)
            repository.updateProfile(profile)
        }
    }

    fun loadCalls () {
        viewModelScope.launch {
            repository.loadCalls()
        }
    }



    fun getCurrentContact (selectedContact: Contact) {
        _currentContact.postValue(selectedContact)
    }

    fun getCurrentCath (selectedChat: Chats) {
        _currentChat.postValue(selectedChat)
    }

    fun loadChatsMessage (chatId: Int) {
        viewModelScope.launch {
            repository.loadChatMessages(chatId)
        }
    }




    fun updateChatMessage (chatId: Int, message: Message) {
        viewModelScope.launch {
            repository.sendChatMessage(message, chatId)

        }
    }

}