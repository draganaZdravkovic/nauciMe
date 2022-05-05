//"Designed by Vectorium / Freepik"
package com.example.naucime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // TODO: povezati preko id lokalno
        auth = FirebaseAuth.getInstance()

        val btnRegister:Button = findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener {

            val editEmail:EditText = findViewById(R.id.editEmail)
            val editPassword:EditText = findViewById(R.id.editPassword)
            val editCPassword:EditText = findViewById(R.id.editCPassword)

            if(editEmail.text.trim().isNotEmpty()
                && editPassword.text.trim().isNotEmpty() && editCPassword.text.trim().isNotEmpty()) {
//                process data
                registerUser()

            } else {
                Toast.makeText(this, "Input required", Toast.LENGTH_SHORT).show()

            }
        }

        val tvLogin:TextView = findViewById(R.id.tvLogin)
        tvLogin.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun registerUser() {

        val editEmail:EditText = findViewById(R.id.editEmail)
        val editPassword:EditText = findViewById(R.id.editPassword)

        auth.createUserWithEmailAndPassword(editEmail.text.trim().toString(), editPassword.text.trim().toString())
            .addOnCompleteListener(this) {

            task -> if(task.isSuccessful) {

                Toast.makeText(this,"Register successful", Toast.LENGTH_SHORT).show()

            } else {

                Toast.makeText(this,"Register failed " + task.exception , Toast.LENGTH_LONG).show()

            }
        }

    }

//    override fun onStart() {
//        super.onStart()
//
//        val user = auth.currentUser
//
//        if (user != null) {
//
//            val intent = Intent(this, StudentDashboardActivity::class.java)
//            startActivity(intent)
//        } else {
//            Log.e("User status", "User null")
//        }
//    }
}