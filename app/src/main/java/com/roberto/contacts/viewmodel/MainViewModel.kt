package com.roberto.contacts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roberto.contacts.adapters.Contacts
import com.roberto.contacts.data.Repo

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