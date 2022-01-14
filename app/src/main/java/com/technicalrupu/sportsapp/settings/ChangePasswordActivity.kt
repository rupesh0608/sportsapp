package com.technicalrupu.sportsapp.settings

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.technicalrupu.sportsapp.HelperClasses.ApiClasses.CommonResponse
import com.technicalrupu.sportsapp.HelperClasses.ApiClasses.CreateUser
import com.technicalrupu.sportsapp.HelperClasses.Retrofit
import com.technicalrupu.sportsapp.R
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
import com.google.gson.Gson
import com.technicalrupu.sportsapp.HelperClasses.ApiClasses.ProfileData


class ChangePasswordActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        val btnBack=findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
        val btnPreview1=findViewById<ImageView>(R.id.btnPreview1)
        btnPreview1.setOnClickListener {
            val edtOldPassword=findViewById<EditText>(R.id.edtOldPassword)
            if(edtOldPassword.transformationMethod != HideReturnsTransformationMethod.getInstance()) {
                edtOldPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            }else{
                edtOldPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }
        val btnPreview2=findViewById<ImageView>(R.id.btnPreview2)
        btnPreview2.setOnClickListener {
            val edtNewPassword=findViewById<EditText>(R.id.edtNewPassword)
            if(edtNewPassword.transformationMethod != HideReturnsTransformationMethod.getInstance()) {
                edtNewPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            }else{
                edtNewPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }
        val btnPreview3=findViewById<ImageView>(R.id.btnPreview3)
        btnPreview3.setOnClickListener {
            val edtConfirmPassword=findViewById<EditText>(R.id.edtConfirmPassword)
            if(edtConfirmPassword.transformationMethod != HideReturnsTransformationMethod.getInstance()) {
                edtConfirmPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            }else{
                edtConfirmPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }

        val btnSave=findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener {

            resetPassword()
        }
    }

    private fun resetPassword() {
        val oldPassword=findViewById<EditText>(R.id.edtOldPassword)
        val newPassword=findViewById<EditText>(R.id.edtNewPassword)
        val confirmPassword=findViewById<EditText>(R.id.edtConfirmPassword)
        val id:Int= getId()
        Log.d("Rupesh", "resetPassword: "+id)
        val retrofit= Retrofit()
        retrofit.create().resetPassword(id,oldPassword.text.toString(),newPassword.text.toString(),confirmPassword.text.toString()).enqueue(
        object : retrofit2.Callback<CommonResponse> {
            override fun onResponse(
                call: Call<CommonResponse>,
                response: Response<CommonResponse>
            ) {

               val data: CommonResponse? =response.body()

                if (data != null) {
                    if(data.getStatus()){
                        Toast.makeText(this@ChangePasswordActivity,
                            data.getMessage(),Toast.LENGTH_SHORT).show()
                        oldPassword.setText("")
                        newPassword.setText("")
                        confirmPassword.setText("")
                    }else{
                            Toast.makeText(this@ChangePasswordActivity,
                                data.getMessage(),Toast.LENGTH_SHORT).show()
                    }
                }


            }

            override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                Toast.makeText(this@ChangePasswordActivity,t.message,Toast.LENGTH_SHORT).show()
            }
        })


    }

    private fun getId(): Int {
        val sharedPref = this.getSharedPreferences(
            "LOGIN_DATA", Context.MODE_PRIVATE
        )
        val gson = Gson()
        val json: String? = sharedPref.getString("data", "")
        val data:ProfileData  = gson.fromJson(json, ProfileData::class.java)

        return data.getId()
    }


}