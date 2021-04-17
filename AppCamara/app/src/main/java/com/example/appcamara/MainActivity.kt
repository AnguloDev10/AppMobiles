package com.example.appcamara

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private val CAMERA_REQUEST_CODE = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     btPermiso.setOnClickListener {
         checkCameraPermission()
     }
    }



    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED){

            requestCameraPermisson()
        }
        else{
            Toast.makeText(this,"Ya se encuentra con permiso de la camara", Toast.LENGTH_LONG).show()
        }
    }
    private fun requestCameraPermisson(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.CAMERA)){
           Toast.makeText(this, "El usuario rechazo el permiso. Habilitalo manual",Toast.LENGTH_LONG).show()
        }
        else
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            CAMERA_REQUEST_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    Toast.makeText(this, "Se habilito el acceso a la camara",Toast.LENGTH_LONG).show()
                }
                else
                {
                     Toast.makeText(this, "Permiso denegado", Toast.LENGTH_LONG).show()
                }
                return
            }
         }
    }
}
