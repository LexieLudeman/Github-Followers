package com.ludeman.githubfollowers.repository

import android.util.Log
import com.ludeman.githubfollowers.common.Followers
import com.ludeman.githubfollowers.data.FollowersRetrofitImpl

class MainRepository(
    private val retrofitImpl: FollowersRetrofitImpl
) {
    suspend fun getFollowers(): List<Followers> {
        Log.d("Checkin", "Main repository")
        val response = retrofitImpl.instance.getFollowers()
        if (response.isSuccessful && response.body() != null) {
            Log.d("Checkin", "Our response is ${response.body()!!}")

            val followers = response.body()!!.map {
                Followers(
                    login = it.login,
                    avatar = it.avatar
                )
            }
            return followers
        } else {
            return listOf(
                Followers(
                    login = "Error",
                    avatar = ""
                )
            )
        }
    }
 }