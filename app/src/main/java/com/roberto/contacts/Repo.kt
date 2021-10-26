package com.roberto.contacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore

class Repo {

    fun getContactData(): LiveData<MutableList<Contacts>>{

        val dataMutable = MutableLiveData<MutableList<Contacts>>()
        FirebaseFirestore.getInstance().collection("Contacs").get().addOnSuccessListener { result ->
            val listData = mutableListOf<Contacts>()
            for (documents in result){
                val imageURL = documents.getString("imageURL")
                val name = documents.getString("name")
                val number = documents.getString("number")
                val contact = Contacts(imageURL!!, name!!, number!!)
                listData.add(contact)
            }
            dataMutable.value = listData
        }
        return dataMutable
    }
}