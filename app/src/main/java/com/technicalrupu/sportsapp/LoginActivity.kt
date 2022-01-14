package com.technicalrupu.sportsapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.technicalrupu.sportsapp.HelperClasses.ApiClasses.UserLogin
import com.technicalrupu.sportsapp.HelperClasses.SharedPreferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        checkForLogin()

        val btnLogin = findViewById<ImageButton>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            login()
        }
        val txtSignUp = findViewById<TextView>(R.id.txtSignUp)
        txtSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        val txtForgotPassword = findViewById<TextView>(R.id.txtForgotPassword)
        txtForgotPassword.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
        val pwdPreview = findViewById<ImageView>(R.id.pwdPreview)
        pwdPreview.setOnClickListener {
            val password = findViewById<EditText>(R.id.edtPassword)
            if (password.transformationMethod != HideReturnsTransformationMethod.getInstance()) {
                password.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                password.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }
    }

    private fun checkForLogin() {
        val sf=SharedPreferences(this@LoginActivity)
        if (sf.getLoginStatus()==true.toString()) {
            goToMainActivity()
        }
    }

    private fun login() {
        val email = findViewById<EditText>(R.id.edtEmail)
        val password = findViewById<EditText>(R.id.edtPassword)
        val retrofit = com.technicalrupu.sportsapp.HelperClasses.Retrofit()
        retrofit.create().login(email.text.toString(), password.text.toString(), "android")
            .enqueue(object : Callback<UserLogin> {
                override fun onResponse(call: Call<UserLogin>, response: Response<UserLogin>) {
                    val data: UserLogin? = response.body()
                    if (response.code() == 200) {
                        if (data != null) {
                            Toast.makeText(
                                this@LoginActivity,
                                data.getMessage(),
                                Toast.LENGTH_LONG
                            ).show()
                            if (data.getStatus()) {
                                val sf=SharedPreferences(this@LoginActivity)
                                sf.saveData(data.getData())
                                goToMainActivity()
                            }

                        }
                    } else {
                        if (data != null) {
                            Toast.makeText(
                                this@LoginActivity,
                                data.getMessage(),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }

                override fun onFailure(call: Call<UserLogin>, t: Throwable) {
                    Toast.makeText(
                        this@LoginActivity,
                        t.message.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }

    fun goToMainActivity() {
        startActivity(Intent(applicationContext, MainActivity::class.java))
        finish()
    }
}