package com.roberto.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout


class MainActivity : AppCompatActivity() {
    //vamos a usar un metodo "obsoleto" de paso de items
    private lateinit var adapter: AdapterItems
    //by lazy hace que la variable se inicialize cuando la necesite
    private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shimmer: ShimmerFrameLayout = findViewById(R.id.shimmer_view_container)

        val recycler: RecyclerView = findViewById(R.id.recycler)

        adapter = AdapterItems(this)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
        observeData(shimmer)

    }

    fun observeData(shimmer: ShimmerFrameLayout){
        shimmer.startShimmer()
        viewModel.fetchContactData().observe(this, Observer {
            shimmer.stopShimmer()
            shimmer.hideShimmer()
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }
}