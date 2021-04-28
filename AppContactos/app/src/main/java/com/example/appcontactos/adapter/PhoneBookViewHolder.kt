package com.example.appcontactos.adapter



import android.graphics.Color
import android.view.View
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.appcontactos.androitext.setUrl
import com.example.appcontactos.datasource.UserPhoneBook
import kotlinx.android.synthetic.main.item_gallery.view.*
import java.util.*

class PhoneBookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun renderView(itemPhoneBook: UserPhoneBook) {
        itemPhoneBook.run {
            itemView.photo.setUrl(url = urlPhoto)
            itemView.name.text = name
            itemView.txNumber.text= telephone.toString()

            itemView.setBackgroundColor(randomColor())
        }
    }


    private fun randomColor(): Int {
        val bound = 256
        val alpha = 100

        val random = Random()
        return Color.argb(
            alpha,
            random.nextInt(bound),
            random.nextInt(bound),
            random.nextInt(bound)
        )
    }
}