package com.ludeman.githubfollowers.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ludeman.githubfollowers.common.Followers
import com.ludeman.githubfollowers.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: MainRepository
): ViewModel() {

    private val _followers: MutableLiveData<List<Followers>> = MutableLiveData()
    val followers: LiveData<List<Followers>> = _followers

    fun getFollowers() {
        Log.d("Checkin", "MainViewModel")
        viewModelScope.launch {
            val followers = mainRepository.getFollowers()
            _followers.value = followers
        }
    }
}
