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
        list.add(Contacts("https://static.wikia.nocookie.net/rap/images/5/5f/Canserbero_1.jpg/revision/latest/scale-to-width-down/1000?cb=20190324221912&path-prefix=es",
                        "Cancerbero", "123456"))

        adapter.setListData(list)
        adapter.notifyDataSetChanged()


    }
}