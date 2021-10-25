package com.roberto.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.roberto.contacts.adapters.AdapterItems
import com.roberto.contacts.adapters.Contacts
import com.roberto.contacts.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {
    //vamos a usar un metodo "obsoleto" de paso de items
    private lateinit var adapter: AdapterItems
    //by lazy hace que la variable se inicialize cuando la necesite
    private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler: RecyclerView = findViewById(R.id.recycler)

        adapter = AdapterItems(this)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

    }
}