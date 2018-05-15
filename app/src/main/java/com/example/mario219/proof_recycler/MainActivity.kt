package com.example.mario219.proof_recycler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
    }

    private fun initRecycler() {
        val adapter =  CustomAdapter(initUsers()) {
            toast("${it.name} clicked")
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        val swipeHelper = SwipeHelper(adapter)
        val itemTouchhelper = ItemTouchHelper(swipeHelper)
        itemTouchhelper.attachToRecyclerView(recyclerView)
    }

    private fun initUsers(): ArrayList<User> {
        var userList: ArrayList<User> = ArrayList()

        val user1: User = User("Mario", "Bogotá")
        val user2: User = User("Antonio", "Cartagena")
        val user3: User = User("Andres", "Medellin")
        userList.add(user1)
        userList.add(user2)
        userList.add(user3)

        return userList
    }

}
