package com.example.naucime

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.naucime.db.DatabaseServiceProvider
import com.example.naucime.model.Professor
import com.example.naucime.model.Test
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgProfesor: ImageView = findViewById(R.id.imgProfesor)

//        animate pulse action
        val scaleDownProfessor:ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(
            imgProfesor,
            PropertyValuesHolder.ofFloat("scaleX", 1.05f),
            PropertyValuesHolder.ofFloat("scaleY", 1.05f));
        scaleDownProfessor.duration = 310;

        scaleDownProfessor.repeatCount = ObjectAnimator.INFINITE;
        scaleDownProfessor.repeatMode = ObjectAnimator.REVERSE;

        scaleDownProfessor.start();
//
        imgProfesor.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("userType", "profesor")
            startActivity(intent)
        }

        val imgStudent:ImageView = findViewById(R.id.imgStudent)

//        animate pulse action
        val scaleDownStudent:ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(
            imgStudent,
            PropertyValuesHolder.ofFloat("scaleX", 1.05f),
            PropertyValuesHolder.ofFloat("scaleY", 1.05f));
        scaleDownStudent.duration = 310;

        scaleDownStudent.repeatCount = ObjectAnimator.INFINITE;
        scaleDownStudent.repeatMode = ObjectAnimator.REVERSE;

        scaleDownStudent.start();
//
        imgStudent.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("userType", "student")
            startActivity(intent)
        }




        val newProfessor = Test("Pera", "Peric")

//        println(Json.encodeToString(newProfessor))
        val test = Json.decodeFromString<Test>("""{name: "pera", language: "Peric"}""")
        println(test.name)
    }
}

