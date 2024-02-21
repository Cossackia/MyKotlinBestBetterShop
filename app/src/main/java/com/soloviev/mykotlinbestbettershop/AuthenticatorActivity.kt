package com.soloviev.mykotlinbestbettershop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AuthenticatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authenticator)

        val login: EditText = findViewById(R.id.login_authenticator)
        val password: EditText = findViewById(R.id.password_authenticator)
        val butRegistration: Button = findViewById(R.id.but_authenticator)
        val butToReg: TextView = findViewById(R.id.but_to_reg)

        butToReg.setOnClickListener {
            val jump = Intent(this, MainActivity::class.java)
            startActivity(jump)
        }

        butRegistration.setOnClickListener {
            val logi = login.text.toString().trim()
            val pass = password.text.toString().trim()

            if (logi == "" || pass == "") {
                Toast.makeText(this, "Ошибка при заполнении данных", Toast.LENGTH_LONG).show()
            } else {

                val DB = BasaDannie(this, null)
                val toAut = DB.getUser(logi, pass)

                if (toAut == true) {
                    Toast.makeText(this, "Пользователь $logi авторизован", Toast.LENGTH_LONG).show()
                    login.text.clear()
                    password.text.clear()

                    val jumpTools = Intent(this, Tools::class.java)
                    startActivity(jumpTools)
                } else
                    Toast.makeText(
                        this,
                        "Пользователь $logi не сущесвтует или неправильный пароль",
                        Toast.LENGTH_LONG
                    ).show()


            }
        }

    }
}