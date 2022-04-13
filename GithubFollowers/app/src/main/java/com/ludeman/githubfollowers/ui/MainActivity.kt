package com.ludeman.githubfollowers.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ludeman.githubfollowers.R
import com.ludeman.githubfollowers.data.FollowersRetrofitImpl
import com.ludeman.githubfollowers.repository.MainRepository
import com.ludeman.githubfollowers.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: FollowersAdapter
    private lateinit var mainViewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel =
            MainViewModel(
                mainRepository = MainRepository(
                    retrofitImpl = FollowersRetrofitImpl
                )
            )

        adapter = FollowersAdapter(
            allFollowers = emptyList(),
            mainViewModel = mainViewModel,
            lifecycleOwner = this
        )
        recyclerView = findViewById(R.id.followers_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        mainViewModel.followers.observe(this) { followers ->
            Log.d("Checkin", "View data is in MainActivity! $followers")
            adapter.updateItems(followers = followers)
        }

        getFollowers()
    }

    private fun getFollowers() {
        Log.d("Checkin", "MainActivity")
        mainViewModel.getFollowers()
    }
}