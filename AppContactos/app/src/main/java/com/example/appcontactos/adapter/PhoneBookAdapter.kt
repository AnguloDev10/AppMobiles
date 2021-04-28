package com.example.appcontactos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appcontactos.R
import com.example.appcontactos.datasource.UserPhoneBook

class PhoneBookAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val itemList = mutableListOf<UserPhoneBook>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gallery, parent, false)

        return PhoneBookViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as PhoneBookViewHolder

        viewHolder.renderView(itemPhoneBook = itemList[position])
    }

    override fun getItemCount() = itemList.size

    fun addNewUserList(userList: MutableList<UserPhoneBook>) {
        itemList.addAll(userList)

        notifyDataSetChanged()
    }
}