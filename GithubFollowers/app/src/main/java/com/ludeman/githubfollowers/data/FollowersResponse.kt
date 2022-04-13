package com.ludeman.githubfollowers.data

import com.google.gson.annotations.SerializedName

//FollowersResponse has to take the raw json and parse to kotlin classes
class FollowersResponse: ArrayList<FollowersResponse.FollowersItem>() {
    data class FollowersItem(
        @SerializedName("login")
        val login: String,
        @SerializedName("avatar_url")
        val avatar: String
    )
}