package com.technicalrupu.sportsapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.technicalrupu.sportsapp.HelperClasses.ApiClasses.CommonResponse
import com.technicalrupu.sportsapp.HelperClasses.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        val btnSend = findViewById<Button>(R.id.btnSend)
        btnSend.setOnClickListener {
            requestForgotPasswordEmail()
        }
        val btnCross = findViewById<ImageView>(R.id.btnCross)
        btnCross.setOnClickListener {
            finish()
        }
    }

    private fun requestForgotPasswordEmail() {
        val email = findViewById<EditText>(R.id.edtEmail)
        val retrofit = Retrofit()
        retrofit.create().forgotPassword(email.text.toString())
            .enqueue(object : Callback<CommonResponse> {
                override fun onResponse(
                    call: Call<CommonResponse>,
                    response: Response<CommonResponse>
                ) {
                    val data: CommonResponse? = response.body()
                    if (data != null) {

                        Toast.makeText(
                            this@ForgotPasswordActivity,
                            data.getMessage().toString(),
                            Toast.LENGTH_LONG
                        ).show()
                        email.setText("")
                    }
                }
                override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                    Toast.makeText(
                        this@ForgotPasswordActivity,
                        t.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

            })
    }
}