package com.soloviev.mykotlinbestbettershop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login: EditText = findViewById(R.id.login_reg)
        val email: EditText = findViewById(R.id.email_reg)
        val password: EditText = findViewById(R.id.password_reg)
        val but_registration: Button = findViewById(R.id.but_reg)
        val butToEntrance: TextView = findViewById(R.id.but_to_entrance)

        butToEntrance.setOnClickListener(){
            val jump = Intent(this, AuthenticatorActivity::class.java)
            startActivity(jump)
        }

        but_registration.setOnClickListener() {
            val logi = login.text.toString().trim()
            val pochta = email.text.toString().trim()
            val pass = password.text.toString().trim()

            if (logi == "" || pochta == "" || pass == "") {
                Toast.makeText(this, "Ошибка при регистрации данных", Toast.LENGTH_LONG).show()
            } else {
                val client = Client(logi, pochta, pass)

                val DB = BasaDannie(this, null)
                DB.newClient(client)
                Toast.makeText(this, "Пользователь $logi добавлен!", Toast.LENGTH_LONG).show()

                login.text.clear()
                email.text.clear()
                password.text.clear()
            }
        }
    }
}