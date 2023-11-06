package com.example.androidstudy.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidstudy.model.User

class MainViewModel: ViewModel() {
    private val userLiveData = MutableLiveData<User>();
    fun getUser():LiveData<User> {
        userLiveData.value = User("chchch")
        return userLiveData
    }
}