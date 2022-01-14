package com.technicalrupu.sportsapp.HelperClasses

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import androidx.core.app.ActivityCompat

class Permission(private val ref:Activity) {


    fun checkPermissions(permissionString:Array<String>, requestCode:Int):Boolean {
//        return if (ContextCompat.checkSelfPermission(
//                ref,
//                permissionString
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            ActivityCompat.requestPermissions(
//                ref,
//                arrayOf(permissionString),
//                requestCode
//            )
//            false
//        } else {
//            true
//        }
        for ( permission in permissionString ) {
            if (ActivityCompat.checkSelfPermission(ref, permission) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ref, permissionString,requestCode )
                return false
            }
        }
        return true
    }
    fun checkPermissionResult(permissionString:Array<String>,requestedCode:Int,permissionName:String,grantResults: IntArray, requestCode: Int): Boolean {
        if (grantResults.isNotEmpty() && requestCode == requestedCode) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                return true
            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        ref,
                        permissionString.toString()
                    )
                ) {
                    openAlert(permissionString,requestCode,permissionName)
                } else {
                    openSettingAlert(permissionName)
                }
                return false
            }
        }
        return false
    }
    private fun openAlert(permissionString: Array<String>, requestCode: Int, openFor:String) {
        val builder = AlertDialog.Builder(ref)
        builder.setTitle("Alert!")
        builder.setMessage("Storage permissions required for $openFor Access")
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setPositiveButton("Retake Permission") { dialogInterface, which ->
            requestPermission(permissionString, requestCode)
        }
        builder.setNegativeButton("Cancel") { dialogInterface, which ->
            ref.finish()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
    private fun openSettingAlert(openFor:String) {
        AlertDialog.Builder(ref)
            .setCancelable(false)
            .setTitle("Permission denied!")
            .setMessage("open setting to allow $openFor permission")
            .setPositiveButton("open setting") { d, _ ->
                ref.finish()
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri = Uri.fromParts("package", ref.packageName, null)
                intent.data = uri
                ref.startActivity(intent)

            }

            .setNegativeButton("cancel") { d, _ ->
                d.dismiss()
                ref.finish()
            }
            .create().show()
    }
    private fun requestPermission(permissionString: Array<String>, requestCode: Int) {
        ActivityCompat.requestPermissions(
            ref,
            permissionString,
            requestCode
        );
    }
}