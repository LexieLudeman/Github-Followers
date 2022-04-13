package com.ludeman.githubfollowers.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FollowersRetrofitImpl {
    lateinit var instance: FollowersRetrofit

    init {
        create()
    }

    private fun create(): FollowersRetrofit {
        val baseURL = "https://api.github.com/users/"
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        instance = retrofit.create(FollowersRetrofit::class.java)
        return instance
    }
}