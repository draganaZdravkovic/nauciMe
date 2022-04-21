package com.example.naucime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ProfesorDashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profesor_dashboard)

        val btNewLesson: Button = findViewById(R.id.btNewLesson)
        btNewLesson.setOnClickListener {

            val intent = Intent(this, AddLessonActivity::class.java)
            startActivity(intent)
        }
    }

}