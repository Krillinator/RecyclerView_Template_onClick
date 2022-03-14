package com.krillinator.recyclerview_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val itemsList = ArrayList<String>()
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        customAdapter = CustomAdapter(itemsList)
        val layoutManager = LinearLayoutManager(applicationContext)

        // NEW - Interface (on Item Click)
        customAdapter.setOnItemClickListener(object: CustomAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                itemsList.removeAt(position)
                customAdapter.notifyItemRemoved(position)
            }
        })

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
    }

    private fun prepareItems() {
        itemsList.add("Apples")
        itemsList.add("Apples1")
        itemsList.add("Apples2")
        itemsList.add("Apples3")
        itemsList.add("Apples4")
        itemsList.add("Apples5")
        itemsList.add("Apples6")
        itemsList.add("Apples7")
        itemsList.add("Apples8")
        itemsList.add("Apples9")
        itemsList.add("Apples10")
        customAdapter.notifyDataSetChanged()
    }
}