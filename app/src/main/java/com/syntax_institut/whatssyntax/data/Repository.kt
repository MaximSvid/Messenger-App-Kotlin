package com.syntax_institut.whatssyntax.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.syntax_institut.whatssyntax.BuildConfig
import com.syntax_institut.whatssyntax.data.local.NotesDatabase
import com.syntax_institut.whatssyntax.data.remote.WhatsSyntaxApi
import com.syntax_institut.whatssyntax.model.Calls
import com.syntax_institut.whatssyntax.model.Chats
import com.syntax_institut.whatssyntax.model.Contact
import com.syntax_institut.whatssyntax.model.Message
import com.syntax_institut.whatssyntax.model.NotesData
import com.syntax_institut.whatssyntax.model.Profile

class Repository(private val database: NotesDatabase) {

    val notesList: LiveData<List<NotesData>> = database.notesDAO.getAll()

    suspend fun insertAll (notesList: List<NotesData>) {
        try {
            for (note in notesList) {
                database.notesDAO.insert(note)
            }
        } catch (e: Exception) {
            Log.e("RepositoryLog", e.message.toString())
        }
    }

    private val number = 9
    private val key = BuildConfig.apiKey

    private var _chatsList = MutableLiveData<List<Chats>> ()
    val chatsList: LiveData<List<Chats>> = _chatsList

    private var _contactList = MutableLiveData<List<Contact>>()
    val contactList: LiveData<List<Contact>> = _contactList

    private var _callList = MutableLiveData <List<Calls>> ()
    val callList: LiveData<List<Calls>> = _callList

    private var _profile = MutableLiveData <Profile> ()
    var profile: LiveData<Profile> = _profile

    private var _messageList = MutableLiveData<List<Message>> ()
    var messageList: LiveData<List<Message>> = _messageList

    suspend fun loadChats() {
        try {
            val response = WhatsSyntaxApi.retrofitService.getChatsList(number, key)
            _chatsList.postValue(response)
        } catch (e: Exception) {
            Log.e("RepositoryLog", e.message.toString())
        }

    }

    suspend fun loadContactList () {
        try {
            val response = WhatsSyntaxApi.retrofitService.getContactsList(number, key)
            _contactList.postValue(response)
        } catch (e: Exception) {
            Log.e("RepositoryLog", e.message.toString())
        }
    }

    suspend fun loadProfile() {
        try {
            val response = WhatsSyntaxApi.retrofitService.getProfile(number, key)
            _profile.postValue(response)
        } catch (e: Exception) {
            Log.e("RepositoryLog", e.message.toString())
        }
    }

    suspend fun updateProfile (profile: Profile) {
        try {
             WhatsSyntaxApi.retrofitService.setProfile(number, profile, key)
        } catch (e: Exception) {
            Log.e("RepositoryLog", e.message.toString())
        }
    }

    suspend fun loadCalls () {
        try {
            val response = WhatsSyntaxApi.retrofitService.getCalls(number, key)
            _callList.postValue(response)
        } catch (e: Exception) {
            Log.e("RepositoryLog", e.message.toString())
        }
    }

    suspend fun loadChatMessages(chatId: Int) {
        try {
            val response = WhatsSyntaxApi.retrofitService.getChatMessage(number, chatId , key)
            _messageList.postValue(response)
        } catch (e: Exception){
            Log.e("RepositoryLog", e.message.toString())
        }
    }

    suspend fun sendChatMessage(message: Message, chatId: Int){
        try {
            WhatsSyntaxApi.retrofitService.sendMessage(number, chatId, message,  key)
        } catch (e: Exception) {
            Log.e("RepositoryLog", e.message.toString())
        }
    }


}