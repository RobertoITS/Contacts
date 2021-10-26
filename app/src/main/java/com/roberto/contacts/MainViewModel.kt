package com.roberto.contacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel: ViewModel() {

    private val repo = Repo()
    fun fetchContactData(): LiveData<MutableList<Contacts>>{

        val mutableData = MutableLiveData<MutableList<Contacts>>()
        repo.getContactData().observeForever{ userList ->
            mutableData.value = userList
        }
        return mutableData

    }

}