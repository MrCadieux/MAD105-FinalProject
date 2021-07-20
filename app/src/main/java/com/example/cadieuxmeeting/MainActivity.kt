package com.example.cadieuxmeeting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    enum class LoginSuccess
    constructor(val codeValue: Int) {
        login(1),
        password(2),
        success(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtLogin = findViewById<TextView>(R.id.usernameEntry)
        val txtPassword = findViewById<TextView>(R.id.passwordEntry)
        val btnLogin = findViewById<Button>(R.id.loginButton)

        btnLogin.setOnClickListener {
            when (CheckLogin(txtLogin.text.toString(), txtPassword.text.toString())){

                LoginSuccess.login -> {
                    Toast.makeText(applicationContext, getString(R.string.errorMessageLogin), Toast.LENGTH_LONG).show()
                    txtLogin.requestFocus()
                }

                LoginSuccess.password -> {
                    Toast.makeText(applicationContext, getString(R.string.errorMessagePassword), Toast.LENGTH_LONG).show()
                    txtPassword.requestFocus()
                }

                else -> {
                    Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()
                }

            }
        }
    }

    fun CheckLogin(txtLogin: String, txtPassword: String): LoginSuccess {
        val holdLogin = "admin"
        val holdPassword = "password"

        if (holdLogin != txtLogin) {
            return LoginSuccess.login
        }
        if (holdPassword != txtPassword) {
            return LoginSuccess.password
        } else {
            return LoginSuccess.success
        }
    }


}