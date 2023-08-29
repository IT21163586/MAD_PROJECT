package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class DeleteProfile : AppCompatActivity() {

//create variable button & text box
    private lateinit var deleteD : Button
    private lateinit var updateD : Button
    private lateinit var userid : EditText
    private lateinit var password : EditText
    private lateinit var db:DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_profile)

//Back button in  action bar
        supportActionBar!!.title = "Delete Profile"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

//set to res id to variable
        deleteD = findViewById(R.id.deleteD)
        updateD = findViewById(R.id.updateD)
        userid = findViewById(R.id.userid)
        password = findViewById(R.id.password)
        db = DBHelper(this)

//delete data using userid and password
        deleteD.setOnClickListener {
            val success = db.deletedata(userid.text.toString(), password.text.toString())
            if (success) {
                Toast.makeText(this, "Profile deleted successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivitySE::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid userid or password", Toast.LENGTH_SHORT).show()
            }
        }

//setonclick use to navigate update class
        updateD.setOnClickListener {
            val intent = Intent(this, UpdateProfile::class.java)
            startActivity(intent)
        }
    }
}
