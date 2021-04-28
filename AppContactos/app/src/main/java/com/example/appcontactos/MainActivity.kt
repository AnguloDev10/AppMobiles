package com.example.appcontactos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appcontactos.adapter.PhoneBookAdapter
import com.example.appcontactos.datasource.loadListUsers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var phoneBookAdapter: PhoneBookAdapter
    val REQUEST_CODE = 1
    var contacts = ArrayList<Contact>()
    var contactAdapter = ContactAdapter(contacts)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAdapter()
        initRecyclerView()
        initValues()
    }

    private fun initAdapter() {
        phoneBookAdapter = PhoneBookAdapter()
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this)

        rvContact.run {
            adapter = phoneBookAdapter
            layoutManager = linearLayoutManager
        }
    }

    private fun initValues() {
        val userList = loadListUsers()

        phoneBookAdapter.addNewUserList(userList)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, ContactActivity::class.java)
        //startActivity(intent)
        startActivityForResult(intent, REQUEST_CODE)

        return super.onOptionsItemSelected(item)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE)
        {
            if (resultCode == Activity.RESULT_OK)
            {
                val name = data!!.getStringExtra("keyName")
                val telephone = data!!.getStringExtra("keyTelephone")

                val contact = Contact(name, telephone)

                contacts.add(contact)
            }
        }
    }
}