package com.example.myapplication2


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class UpdateProfile : AppCompatActivity() {

    private lateinit var deleteU: Button
    private lateinit var updateU: Button
    private lateinit var username: EditText
    private lateinit var role: EditText
    private lateinit var userid: EditText
    private lateinit var phone: EditText
    private lateinit var address: EditText
    private lateinit var password: EditText
    private lateinit var repassword: EditText
    private lateinit var db: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)
//Back button in  action bar
       supportActionBar!!.title = "Update Profile"
       supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        deleteU = findViewById(R.id.deleteU)
        updateU = findViewById(R.id.updateU)
        username = findViewById(R.id.username)
        role = findViewById(R.id.role)
        userid = findViewById(R.id.userid)
        phone = findViewById(R.id.phone)
        address = findViewById(R.id.address)
        password = findViewById(R.id.password)
        repassword = findViewById(R.id.repassword)
        db = DBHelper(this)

//update the data using update data function using
        updateU.setOnClickListener {
            val untext = username.text.toString()
            val rotext = role.text.toString()
            val uidtext = userid.text.toString()
            val phtext = phone.text.toString()
            val adtext = address.text.toString()
            val pwtext = password.text.toString()
            val repwtext = repassword.text.toString()

            if (TextUtils.isEmpty(untext) || TextUtils.isEmpty(rotext) || TextUtils.isEmpty(uidtext) || TextUtils.isEmpty(phtext) || TextUtils.isEmpty(adtext) ||TextUtils.isEmpty(pwtext) || TextUtils.isEmpty(repwtext)) {
                Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show()
            } else {
                if (pwtext == repwtext) {
                    val success = db.updateData(untext,rotext, uidtext, phtext,adtext, pwtext)
                    if (success) {
                        Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Failed to update profile", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
            }
        }

        deleteU.setOnClickListener {
            val intent = Intent(this, DeleteProfile::class.java)
            startActivity(intent)
        }
    }
}
