package com.me92100984.dgtodo.ui
import android.content.Intent
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.me92100984.dgtodo.R
import com.me92100984.dgtodo.adapter.TodoAdapter
import com.me92100984.dgtodo.data.TodoDatabase
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var todoDatabase: TodoDatabase
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoDatabase = TodoDatabase.getDatabase(this)

        // RecyclerView 연결
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        todoAdapter = TodoAdapter {todo ->
            lifecycleScope.launch {
                todoDatabase.todoDao().update(todo.copy(completed = !todo.completed))
                loadTodos()
            }
        }

        recyclerView.adapter = todoAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, AddTodoActivity::class.java)
            startActivityForResult(intent, ADD_TODO_REQUEST_CODE)
        }

        findViewById<FloatingActionButton>(R.id.fab_web).setOnClickListener {
            val intent = Intent(this, WebActivity::class.java)
            startActivity(intent)
        }
        loadTodos()

        // sound
        val soundPool = SoundPool.Builder().build()
        val ding = soundPool.load(this, R.raw.ring10,1)

        // media
        val mediaPlayer = MediaPlayer.create(this, R.raw.goldenbell)

        // sound
        findViewById<FloatingActionButton>(R.id.fab_ding).setOnClickListener {
            soundPool.play(ding, 1f, 1f, 0, 0, 1f)
        }

        // media
        findViewById<FloatingActionButton>(R.id.fab_music).setOnClickListener {
            mediaPlayer.start()
        }
    }

    private fun loadTodos() {
        lifecycleScope.launch {
            val todos = todoDatabase.todoDao().getAllTodos()
            todoAdapter.submitList(todos)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == ADD_TODO_REQUEST_CODE && resultCode == RESULT_OK)
            loadTodos()
    }

    companion object {
        private const val ADD_TODO_REQUEST_CODE = 1001
    }
}