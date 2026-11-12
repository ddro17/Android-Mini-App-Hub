package com.example.multi
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.multi.R
import com.example.multi.calculator
import com.example.multi.catselector
import com.example.multi.loginapp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Button to open App 1
        findViewById<Button>(R.id.button_app1).setOnClickListener {
            val intent = Intent(this, calculator::class.java)
            startActivity(intent)
        }

        // Button to open App 2
        findViewById<Button>(R.id.button_app2).setOnClickListener {
            val intent = Intent(this, loginapp::class.java)
            startActivity(intent)
        }

        // Button to open App 3
        findViewById<Button>(R.id.button_app3).setOnClickListener {
            val intent = Intent(this, catselector::class.java)
            startActivity(intent)
        }
    }
}
