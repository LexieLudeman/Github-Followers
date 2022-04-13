package com.ludeman.githubfollowers.data

import retrofit2.Response
import retrofit2.http.GET

interface FollowersRetrofit {

    @GET("LexieLudeman/followers")
    suspend fun getFollowers(): Response<FollowersResponse>
}