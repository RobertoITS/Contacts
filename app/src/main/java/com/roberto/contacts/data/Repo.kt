package com.roberto.contacts.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.roberto.contacts.adapters.Contacts

class Repo {

    fun getContactData(): LiveData<MutableList<Contacts>>{

        val dataMutable = MutableLiveData<MutableList<Contacts>>()
        FirebaseFirestore.getInstance().collection("Contacs").get().addOnSuccessListener { result ->
            for (documents in result){
                val imageURL =
            }
        }

    }

}