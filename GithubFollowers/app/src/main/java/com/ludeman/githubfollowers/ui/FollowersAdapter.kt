package com.ludeman.githubfollowers.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.ludeman.githubfollowers.R
import com.ludeman.githubfollowers.common.Followers
import com.ludeman.githubfollowers.viewmodel.MainViewModel
import com.squareup.picasso.Picasso

class FollowersAdapter (
    private var allFollowers: List<Followers>,
    mainViewModel: MainViewModel,
    lifecycleOwner: LifecycleOwner
) : RecyclerView.Adapter<FollowersAdapter.FollowersViewHolder>() {

    private val picasso = Picasso.get()

    inner class FollowersViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val loginText: TextView = view.findViewById(R.id.login)
        private val avatar: ImageView = view.findViewById(R.id.avatar)

        fun bind(followers: Followers) {
            loginText.text = followers.login
            picasso.load(followers.avatar).into(avatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowersViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recyclerview_row, parent, false)
        return FollowersViewHolder(view)
    }

    override fun onBindViewHolder(holder: FollowersViewHolder, position: Int) {
        holder.bind(followers = allFollowers[position])
    }

    override fun getItemCount() = allFollowers.size

    fun updateItems(followers: List<Followers>) {
        allFollowers += followers
        notifyDataSetChanged()
    }

}