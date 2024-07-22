package com.syntax_institut.whatssyntax.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.syntax_institut.whatssyntax.data.remote.WhatsSyntaxApi
import com.syntax_institut.whatssyntax.model.Calls
import com.syntax_institut.whatssyntax.model.Chats
import com.syntax_institut.whatssyntax.model.Contact
import com.syntax_institut.whatssyntax.model.Message
import com.syntax_institut.whatssyntax.model.Profile

class Repository() {

    private val number = 0
    private val key = ""

    private var _chatsList = MutableLiveData<List<Chats>> ()
    val chatsList: LiveData<List<Chats>> = _chatsList

    private var _contactList = MutableLiveData<List<Contact>>()
    val contactList: LiveData<List<Contact>> = _contactList

    private var _callList = MutableLiveData <List<Calls>> ()
    val callList: LiveData<List<Calls>> = _callList

    private var _profile = MutableLiveData<List<Profile>> ()
    var profile: LiveData<List<Profile>> = _profile

    private var _messageList = MutableLiveData<List<Message>> ()
    var messageList: LiveData<List<Message>> = _messageList

    suspend fun loadChats() {
        try {
            val response = WhatsSyntaxApi.retrofitService.getChatsList(9, "Dangerous")
            _chatsList.postValue(response)
        } catch (e: Exception) {
            Log.e("RepositoryLog", e.message.toString())
        }

    }

    suspend fun loadContactList () {
        try {
            val response = WhatsSyntaxApi.retrofitService.getContactsList(9, "Dangerous")
            _contactList.postValue(response)
        } catch (e: Exception) {
            Log.e("RepositoryLog", e.message.toString())
        }
    }


}