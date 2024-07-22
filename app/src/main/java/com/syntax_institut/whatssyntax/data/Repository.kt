package com.syntax_institut.whatssyntax.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.syntax_institut.whatssyntax.data.remote.WhatsSyntaxApi
import com.syntax_institut.whatssyntax.model.Chats

class Repository() {

    private val number = 0
    private val key = ""

    private val _chatsList = MutableLiveData<List<Chats>> ()
    val chatsList: LiveData<List<Chats>> = _chatsList

    suspend fun loadChats() {
        try {
            val response = WhatsSyntaxApi.retrofitService.getChatsList(9, "Dangerous")
            _chatsList.postValue(response)
        } catch (e: Exception) {
            Log.e("RepositoryLog", e.message.toString())
        }



    }


}