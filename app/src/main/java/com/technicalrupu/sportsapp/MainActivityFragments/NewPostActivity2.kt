package com.technicalrupu.sportsapp.MainActivityFragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore.Images
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.technicalrupu.sportsapp.HelperClasses.ApiClasses.ImageResponse
import com.technicalrupu.sportsapp.HelperClasses.ApiClasses.ProfileData
import com.technicalrupu.sportsapp.HelperClasses.Chip
import com.technicalrupu.sportsapp.HelperClasses.Retrofit
import com.technicalrupu.sportsapp.HelperClasses.SharedPreferences
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File

import android.graphics.*
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.Toast

import com.technicalrupu.sportsapp.R

class NewPostActivity2 : AppCompatActivity() {
    private val hashtagList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post2)
        setImage()

        val btnPost = findViewById<Button>(R.id.btnPost)
        btnPost.setOnClickListener {
            if (intent.hasExtra("byteArray")) {
                val bitmap = BitmapFactory.decodeByteArray(
                    intent.getByteArrayExtra("byteArray"),
                    0,
                    intent.getByteArrayExtra("byteArray")!!.size
                )
                Log.d("rupesh", "onCreate: "+bitmap)
                val tempUri: Uri = getImageUri(applicationContext, bitmap)
                val finalFile = File(getRealPathFromURI(tempUri))
                val edtDescription=findViewById<EditText>(R.id.edtDescription)
                val sf= SharedPreferences(this)
                val profileData: ProfileData = sf.getProfileData()!!
                val userId=profileData.getId()
                uploadImage(userId,edtDescription.text.toString(),finalFile,hashtagList)
            }

        }


        val edtHashtag=findViewById<EditText>(R.id.edtHashtag)
        edtHashtag.setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    val chip= Chip(this)
                    chip.addRemovableChip(edtHashtag.text.toString(), hashtagList)
                    edtHashtag.setText("")
                    true
                }
                else -> false
            }
        }
        val btnBack=findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {

            val intent = Intent()
            setResult(Activity.RESULT_CANCELED, intent)
            finish()
        }

    }





    override fun onBackPressed() {
        val intent = Intent()
        setResult(Activity.RESULT_CANCELED, intent)
        finish()
    }



    private fun uploadImage(user_id:Int, description:String, finalFile: File, hashtagList:ArrayList<String>) {
        val userId:RequestBody=RequestBody.create(MediaType.parse("multipart/form-data"), user_id.toString());
        val description:RequestBody=RequestBody.create(MediaType.parse("multipart/form-data"), description);
        val requestFile: RequestBody =
            RequestBody.create(MediaType.parse("image/*"), finalFile)
        val image = MultipartBody.Part.createFormData("image", finalFile.name, requestFile)

        val retrofit=Retrofit()
        retrofit.create().addNewPost(userId, description,image,hashtagList).enqueue(object :
            Callback<ImageResponse> {
            override fun onResponse(call: Call<ImageResponse>, response: Response<ImageResponse>) {
                 val data: ImageResponse? =response.body()
                if (data != null) {
                    val intent = Intent()
                    intent.putExtra("response",data.getMessage())
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }

            override fun onFailure(call: Call<ImageResponse>, t: Throwable) {
                val intent = Intent()
                intent.putExtra("response","Failed to Upload post... Error:"+t.message)
                setResult(Activity.RESULT_CANCELED, intent)
                finish()
            }
        })
    }

    private fun getImageUri(inContext: Context, inImage: Bitmap): Uri {
        val bytes = ByteArrayOutputStream()
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path = Images.Media.insertImage(inContext.contentResolver, inImage, "xyz", null)
        return Uri.parse(path)
    }

    private fun getRealPathFromURI(uri: Uri): String {
        var path = ""
        if (contentResolver != null) {
            val cursor: Cursor? = contentResolver.query(uri, null, null, null, null)
            if (cursor != null) {
                cursor.moveToFirst()
                val idx: Int = cursor.getColumnIndex(Images.ImageColumns.DATA)
                path = cursor.getString(idx)
                cursor.close()
            }
        }
        return path
    }

    private  fun setImage(){
        if (intent.hasExtra("byteArray")){
            val imageView = findViewById<ImageView>(R.id.ImageView)
            val bitmap: Bitmap= BitmapFactory.decodeByteArray(
                intent.getByteArrayExtra("byteArray"),
                0,
                intent.getByteArrayExtra("byteArray")!!.size
            )
            imageView.setImageBitmap(bitmap)

        }
    }
}