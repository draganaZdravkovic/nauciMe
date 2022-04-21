package com.example.naucime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgProfesor: CardView = findViewById(R.id.imgProfesor)


        imgProfesor.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("userType", "profesor")
            startActivity(intent)
        }

        val imgStudent:CardView = findViewById(R.id.imgStudent)

        imgStudent.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("userType", "student")
            startActivity(intent)
        }

    }
}
