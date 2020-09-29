package com.example.dagger_two_terminal_commands.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class RetrofitClient @Inject constructor() {


    private val Base_Url = "https://terminalcommands.herokuapp.com/"

    fun getClient(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder().baseUrl(Base_Url).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


}