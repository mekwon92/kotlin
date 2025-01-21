package com.me92100984.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.me92100984.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.text_view)


//        setContentView(R.layout.list_layout)
//
//        val fruits = listOf("파인애플","사과","바나나","복숭아","포도","리치","구아바","망고","파인애플","사과","바나나","복숭아","포도","리치","구아바","망고","멜론","파인애플","사과","바나나","복숭아","포도","리치","구아바","망고","멜론")
//        val listView:ListView = findViewById(R.id.listView)
//
//        //adapter
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, fruits)
//        listView.adapter = adapter
//        listView.setOnItemClickListener{_, _, position, _ ->
//           // position이 index임
//            val value = fruits[position];
//            Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
//        }


//        setContentView(R.layout.activity_main_)
//        val input:EditText = findViewById(R.id.editTextText)
//        val button:Button = findViewById(R.id.button)
//
//        button.setOnClickListener {
//            val textValue = input.text.toString();
//            if(textValue.isBlank()) {
//                Toast.makeText(this, "값을 입력하세요", Toast.LENGTH_SHORT).show()
//            }
//            else {
//                Toast.makeText(this, "안녕하세요 $textValue 님", Toast.LENGTH_SHORT).show()
//            }
//        }

//        enableEdgeToEdge()
//        setContent {
//            MyApplicationTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "World",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}