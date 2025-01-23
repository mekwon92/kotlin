package com.me92100984.dgtodo.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.me92100984.dgtodo.R
import com.me92100984.dgtodo.data.Todo
import com.me92100984.dgtodo.data.TodoDatabase
import kotlinx.coroutines.launch

class AddTodoActivity: AppCompatActivity (){
    private lateinit var todoDatabase: TodoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_todo_activity)

        todoDatabase = TodoDatabase.getDatabase(this)

        val inputTitle = findViewById<EditText>(R.id.inputTitle)
        val btnAdd = findViewById<Button>(R.id.btnAdd)

        btnAdd.setOnClickListener {
            val title = inputTitle.text.toString()
            Log.d("제목확인용",title)
            if(title.isNotBlank()) {
                lifecycleScope.launch {
                    val newTodo = Todo(title = title)
                    Log.d("todo 확인", newTodo.toString())

                    todoDatabase.todoDao().insert(newTodo)

                    //active mode
                    setResult(RESULT_OK)
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                    finish()
                }
            }
            else {
                inputTitle.error="비어있음"
            }
        }
    }
}