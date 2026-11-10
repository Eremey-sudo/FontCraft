package com.fontcraft

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fontcraft.ui.projectlist.ProjectAdapterSimple
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val projectList = mutableListOf<String>()
    private lateinit var adapter: ProjectAdapterSimple

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val fabAdd = findViewById<FloatingActionButton>(R.id.fabAdd)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ProjectAdapterSimple(projectList)
        recyclerView.adapter = adapter

        fabAdd.setOnClickListener {
            projectList.add("Шрифт ${projectList.size + 1}")
            adapter.notifyItemInserted(projectList.size - 1)
            Toast.makeText(this, "Проект создан!", Toast.LENGTH_SHORT).show()
        }
    }
}