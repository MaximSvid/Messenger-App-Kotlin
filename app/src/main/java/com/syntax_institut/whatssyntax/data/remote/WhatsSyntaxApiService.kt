package com.syntax_institut.whatssyntax.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.syntax_institut.whatssyntax.model.Calls
import com.syntax_institut.whatssyntax.model.Chats
import com.syntax_institut.whatssyntax.model.Contact
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "http://81.169.201.230:8080"

// http://81.169.201.230:8080/group/9/chats?key=Dangerous

private val logger: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private val httpClient = OkHttpClient.Builder()
    .addInterceptor(logger)
    .build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(httpClient)
    .build()

interface WhatsSyntaxApiService {

    // TODO()

    //    val number: Int = 9
//    val key = Dangerous
    @GET("group/{number}/chats")
    suspend fun getChatsList(
        @Path("number") number: Int,
        @Query("key") key: String
    ): List<Chats>

    @GET ("group/9/contacts")
    suspend fun getContactsList (
        @Query("key") key: String
    ) : List<Contact>


    @GET ("group/9/contacts")
    suspend fun getContactList (
        @Query("key") key: String
    ) : List<Contact>

}

object WhatsSyntaxApi {
    val retrofitService: WhatsSyntaxApiService by lazy { retrofit.create(WhatsSyntaxApiService::class.java) }
}