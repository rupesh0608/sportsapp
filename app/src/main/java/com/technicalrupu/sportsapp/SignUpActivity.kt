package com.technicalrupu.sportsapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.technicalrupu.sportsapp.HelperClasses.ApiClasses.CreateUser
import com.technicalrupu.sportsapp.HelperClasses.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val firstName = findViewById<EditText>(R.id.edtFirstName)
        val lastName = findViewById<EditText>(R.id.edtLastName)
        val userName = findViewById<EditText>(R.id.edtUserName)
        val email = findViewById<EditText>(R.id.edtEmail)
        val password = findViewById<EditText>(R.id.edtPassword)
        val confirmPassword = findViewById<EditText>(R.id.edtConfirmPassword)
        val pwdBtn1=findViewById<ImageView>(R.id.pwdBtn)
        val pwdBtn2=findViewById<ImageView>(R.id.pwdBtn2)

        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        btnSignUp.setOnClickListener {

            signUp(
                userName.text.toString(),
                firstName.text.toString(),
                lastName.text.toString(),
                email.text.toString(),
                password.text.toString(),
                confirmPassword.text.toString(),
                "android"
            )
        }
        pwdBtn1.setOnClickListener {
            if(password.transformationMethod != HideReturnsTransformationMethod.getInstance()) {
                password.transformationMethod = HideReturnsTransformationMethod.getInstance()
            }else{
                password.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }
        pwdBtn2.setOnClickListener {
            if(confirmPassword.transformationMethod != HideReturnsTransformationMethod.getInstance()) {
                confirmPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            }else{
                confirmPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }
    }



    private fun signUp(
        userName: String,
        firstName: String,
        lastName: String,
        email: String,
        password: String,
        confirmPassword: String,
        deviceToken: String
    ) {
        val retrofit = Retrofit()
        retrofit.create().createUser(
            userName, firstName, lastName, email, password, confirmPassword, deviceToken
        ).enqueue(object : Callback<CreateUser> {
            override fun onResponse(call: Call<CreateUser>, response: Response<CreateUser>) {
                val data: CreateUser? = response.body()
                if (response.code() == 200) {
                    if (data != null) {
                        Toast.makeText(
                            this@SignUpActivity,
                            data.getMessage(),
                            Toast.LENGTH_LONG
                        ).show()
                        if (data.getStatus()) {
                            gotoLogin()
                        }

                    }
                } else {
                    if (data != null) {
                        Toast.makeText(
                            this@SignUpActivity,
                            data.getMessage(),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

            override fun onFailure(call: Call<CreateUser>, t: Throwable) {
                Toast.makeText(this@SignUpActivity, "failed " + t.message, Toast.LENGTH_LONG)
                    .show()
            }
        })
    }

    fun gotoLogin(){
        startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
        finish()
    }

}