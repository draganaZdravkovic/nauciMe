package com.example.naucime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val btnLogin: Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener{

            val etUsername: EditText = findViewById(R.id.etUsername)
            val etPassword: EditText = findViewById(R.id.etPassword)

            if(etUsername.text.trim().isNotEmpty() && etPassword.text.trim().isNotEmpty()){
//                process data
                signInUser()
            } else {
                Toast.makeText(this, "Input required", Toast.LENGTH_SHORT).show()

            }
        }

        val tvRegister: TextView = findViewById(R.id.tvRegister)
        tvRegister.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    fun signInUser() {

        val etUsername:EditText = findViewById(R.id.etUsername)
        val etPassword:EditText = findViewById(R.id.etPassword)
        val userType: String = intent.getStringExtra("userType").toString()

        auth.signInWithEmailAndPassword(etUsername.text.trim().toString(),etPassword.text.trim().toString())
            .addOnCompleteListener(this) {
                    task -> if (task.isSuccessful) {

                        val intent = Intent(this, if (userType == "student") StudentDashboardActivity::class.java else ProfesorDashboardActivity::class.java)
                        startActivity(intent)

            } else {
                Toast.makeText(this,"Authentication error " + task.exception, Toast.LENGTH_LONG).show()

            }
            }
    }

//    override fun onStart() {
//        super.onStart()
//
//        val user = auth.currentUser
//
////        if (user != null) {
////
////            val intent = Intent(this, DashboardActivity::class.java)
////            startActivity(intent)
////        } else {
////            Toast.makeText(this,"User first time login", Toast.LENGTH_LONG)
////        }
//    }
}