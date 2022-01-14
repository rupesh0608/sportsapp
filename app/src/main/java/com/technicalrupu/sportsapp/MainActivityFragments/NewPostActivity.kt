package com.technicalrupu.sportsapp.MainActivityFragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.MediaColumns
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.sportsapp.HelperClasses.File
import com.technicalrupu.sportsapp.HelperClasses.Permission
import com.technicalrupu.sportsapp.R
import com.technicalrupu.sportsapp.settings.Adapter.GalleryAdapter
import java.io.ByteArrayOutputStream


public class NewPostActivity : AppCompatActivity() {
    val REQUEST_CODE_STORAGE: Int = 101
    val REQUEST_CODE_CAMERA: Int = 102
    val recyclerView: RecyclerView? = null
    var imageAllPath: ArrayList<String>? = null

    var storagePermissions = arrayOf(
        android.Manifest.permission.READ_EXTERNAL_STORAGE,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    var cameraPermissions = arrayOf(android.Manifest.permission.CAMERA)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)

        checkStoragePermissions(storagePermissions)


        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        val btnFront = findViewById<ImageView>(R.id.btnFront)
        btnFront.setOnClickListener {
            val imageView = findViewById<ImageView>(R.id.mainImageView)
            val bmap = imageView.drawingCache
            if (bmap == null) {
                Toast.makeText(this, "Please Select Image..", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, NewPostActivity2::class.java)
                val bitmap: Bitmap = bmap
                val bs = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bs)
                intent.putExtra("byteArray", bs.toByteArray())
                startActivityForResult(intent, 101)
            }
        }

        val btnCamera = findViewById<ImageView>(R.id.btnCamera)
        btnCamera.setOnClickListener {
            checkCameraPermission()
        }

    }

    private fun checkCameraPermission() {
        val permission = Permission(this)
        if (permission.checkPermissions(cameraPermissions, REQUEST_CODE_CAMERA)) {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, REQUEST_CODE_CAMERA)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101) {
            if (resultCode == Activity.RESULT_OK) {
                val msg = data!!.getStringExtra("response")
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                finish()
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                val msg = data!!.getStringExtra("response")
                if (msg != null) {
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                }

            }
        }
        if (requestCode == REQUEST_CODE_CAMERA) {
            if (resultCode == RESULT_OK) {
                val imageView = findViewById<ImageView>(R.id.mainImageView)
                val imageBitmap = data?.extras?.get("data") as Bitmap
                imageView.setImageBitmap(imageBitmap)
                imageView.setDrawingCacheEnabled(true)
                val drawable = imageView.drawable as BitmapDrawable
                val bitmap = drawable.bitmap
                val backgroundTask = BackgroundTask(this, bitmap)
                backgroundTask.execute(100)
            }
        }

    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,

        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CODE_STORAGE) {
            checkResultForStoragePermission(
                storagePermissions,
                REQUEST_CODE_STORAGE,
                "Storage",
                grantResults,
                requestCode
            )
        }
        if (requestCode == REQUEST_CODE_CAMERA) {
            checkResultForCameraPermission(
                cameraPermissions,
                REQUEST_CODE_CAMERA,
                "Camera",
                grantResults,
                requestCode
            )
        }
    }


    @SuppressLint("StaticFieldLeak")
    inner class MyTask(var ref: Activity) : AsyncTask<Void?, Void?, Void?>() {

        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun onPostExecute(aVoid: Void?) {
            super.onPostExecute(aVoid)

            val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
            recyclerview.layoutManager = GridLayoutManager(ref, 3)
            val adapter = imageAllPath?.let { GalleryAdapter(it, ref) }
            recyclerview.adapter = adapter


        }

        override fun doInBackground(vararg p0: Void?): Void? {
            try {
                imageAllPath = getAllShownImagesPath(ref)
            } catch (e: Exception) {
                Log.d("Rupesh", "onPostExecute: " + e.message)
            }
            return null
        }
    }

    @SuppressLint("StaticFieldLeak")
    inner class BackgroundTask(var ref: Activity, val bitmap: Bitmap) :
        AsyncTask<Int, Int, Void>() {

        override fun doInBackground(vararg params: Int?): Void? {
            val file = File(ref)
            file.saveImage(bitmap)
            return null
        }

        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
        }

        override fun onCancelled(result: Void?) {
            super.onCancelled(result)

        }

        override fun onCancelled() {
            super.onCancelled()
        }
    }

    private fun getAllShownImagesPath(activity: Activity): ArrayList<String> {
        val cursor: Cursor?
        val listOfAllImages = ArrayList<String>()
        val uri: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaColumns.DATA,
            MediaStore.Images.Media.BUCKET_DISPLAY_NAME
        )

        cursor = activity.contentResolver.query(
            uri, projection, null,
            null, null
        )
        if (cursor != null) {
            val column_index_data = cursor.getColumnIndexOrThrow(MediaColumns.DATA)
            while (cursor.moveToNext()) {
                val absolutePathOfImage: String = cursor.getString(column_index_data)
                listOfAllImages.add(absolutePathOfImage)
            }

        }
        return listOfAllImages
    }

    private fun checkStoragePermissions(storagePermissions: Array<String>) {
        val permission = Permission(this)

        val status = permission.checkPermissions(storagePermissions, REQUEST_CODE_STORAGE)
        if (status) {
            val myTask = MyTask(this)
            myTask.execute()
        }
    }

    private fun checkResultForStoragePermission(
        permissionString: Array<String>,
        requestedCode: Int,
        permissionName: String,
        grantResults: IntArray,
        requestCode: Int,
    ) {

        val permission = Permission(this)
        if (permission.checkPermissionResult(
                permissionString,
                requestedCode,
                permissionName,
                grantResults,
                requestCode
            )
        ) {
            val myTask = MyTask(this)
            myTask.execute()
        }
    }

    private fun checkResultForCameraPermission(
        permissionString: Array<String>,
        requestedCode: Int,
        permissionName: String,
        grantResults: IntArray,
        requestCode: Int
    ) {
        val permission = Permission(this)
        if (permission.checkPermissionResult(
                permissionString,
                requestedCode,
                permissionName,
                grantResults,
                requestCode
            )
        ) {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            this.startActivityForResult(cameraIntent, REQUEST_CODE_CAMERA)
        }
    }
}