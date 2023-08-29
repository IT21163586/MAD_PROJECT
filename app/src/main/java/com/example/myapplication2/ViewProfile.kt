package com.example.myapplication2


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ViewProfile : AppCompatActivity() {

    private lateinit var update : Button
    private lateinit var view : Button
    private lateinit var db:DBHelper
    private lateinit var userid : EditText
    private lateinit var username : EditText
    private lateinit var role : EditText
    private lateinit var address : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_profile)

//Back button in  action bar
        supportActionBar!!.title = "View Profile"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        update = findViewById(R.id.update)
        view = findViewById(R.id.view)
        userid = findViewById(R.id.userid)
        username = findViewById(R.id.username)
        role = findViewById(R.id.role)
        address = findViewById(R.id.address)
        db = DBHelper(this)


//view data view data function using
        view.setOnClickListener {
            //val x = userid.text.toString()
            //val password = passwordL.text.toString()
            val cursor = db.viewdata(userid.text.toString())

            if (cursor?.count == 0) {
                Toast.makeText(this, "Enter your id no correctly view your data", Toast.LENGTH_SHORT).show()

            } else {
                val stringBuffer = StringBuffer()
                while (cursor!!.moveToNext()) {
                    val usernameEditText: EditText = findViewById(R.id.username) // Replace `username` with the ID of your username EditText view
                    usernameEditText.setText(cursor.getString(0))

                    val roleEditText: EditText = findViewById(R.id.role) // Replace `userID` with the ID of your userID EditText view
                    roleEditText.setText(cursor.getString(1))

                    val userIDEditText: EditText = findViewById(R.id.userid) // Replace `userID` with the ID of your userID EditText view
                    userIDEditText.setText(cursor.getString(2))

                    val phoneNoEditText: EditText = findViewById(R.id.phone) // Replace `phoneNo` with the ID of your phoneNo EditText view
                    phoneNoEditText.setText(cursor.getString(3))

                    val addressEditText: EditText = findViewById(R.id.address) // Replace `password` with the ID of your password EditText view
                    addressEditText.setText(cursor.getString(4))
                }
            }
        }

        update.setOnClickListener {
            val intent = Intent(this, UpdateProfile::class.java)
            startActivity(intent)
        }

    }
}