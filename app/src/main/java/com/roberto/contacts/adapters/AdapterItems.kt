package com.roberto.contacts.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.roberto.contacts.R
import kotlin.coroutines.coroutineContext

//val dataSet: ArrayList<String>//
class AdapterItems(private val context: Context): RecyclerView.Adapter<AdapterItems.ViewHolder>() {

    private var dataList = mutableListOf<Contacts>()

    fun setListData(data: MutableList<Contacts>){
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_contact,
            parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.name.text = dataSet[position]
        val user = dataList[position]
        holder.bindView(user)
    }

    override fun getItemCount(): Int {
        return if(dataList.size > 0){
            dataList.size
        } else{
            0
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val name: TextView = itemView.findViewById(R.id.name)
        fun bindView(contacts: Contacts){
            //Vamos a usar Glide para cargar las imagenes - Se cargan en la card view
            Glide.with(context).load(contacts.imgUrl).into(itemView.findViewById(R.id.image))
            itemView.findViewById<TextView>(R.id.name).text = contacts.name
            itemView.findViewById<TextView>(R.id.number).text = contacts.number
        }
    }
}