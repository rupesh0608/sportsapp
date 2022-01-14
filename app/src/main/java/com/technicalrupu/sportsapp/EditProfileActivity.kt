package com.technicalrupu.sportsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
         val edtUsername=findViewById<EditText>(R.id.edtUserName)
         val edtName=findViewById<EditText>(R.id.edtName)
         val edtEmail=findViewById<EditText>(R.id.edtEmail)
         val edtDoj=findViewById<EditText>(R.id.edtDOJ)

        edtUsername.setText("Deepika Kumari08")
        edtName.setText("Deepika Kumari")
        edtEmail.setText("deepikakumari84@gmail.com")
        edtDoj.setText("24/05/19")
        val layout=findViewById<LinearLayout>(R.id.layoutContainer)
        layout.alpha=0.4F
        val btnBack=findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
        val btnEditSave=findViewById<Button>(R.id.btnEditSave)
        btnEditSave.setOnClickListener {
            if(btnEditSave.text=="Edit")
            {
                layout.alpha=1F
                btnEditSave.text="Save"
            }else{
                layout.alpha=0.4F
                btnEditSave.text="Edit"
                finish()
            }
        }
    }
}