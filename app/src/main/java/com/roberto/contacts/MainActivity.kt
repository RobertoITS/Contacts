package com.roberto.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.roberto.contacts.adapters.AdapterItems
import com.roberto.contacts.adapters.Contacts

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: AdapterItems
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler: RecyclerView = findViewById(R.id.recycler)

        adapter = AdapterItems(this)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        val list: MutableList<Contacts> = mutableListOf<Contacts>()
        list.add(Contacts("https://www.google.com/url?sa=i&url=https%3A%2F%2Frap.fandom.com%2Fes%2Fwiki%2FCanserbero&psig=AOvVaw2K_oWBcZWAyhql5hm7tMCN&ust=1634923812963000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLjT-eOD3PMCFQAAAAAdAAAAABAD",
                        "Cancerbero", "123456"))

        adapter.setListData(list)
        adapter.notifyDataSetChanged()


    }
}