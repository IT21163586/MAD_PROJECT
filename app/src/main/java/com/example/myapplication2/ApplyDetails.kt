package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ApplyDetails : AppCompatActivity() {

    private lateinit var editV : Button
    private lateinit var viewV : Button
    private lateinit var deleteV : Button

    private lateinit var Code : EditText
    private lateinit var UserName : EditText
    private lateinit var Qualification : EditText
    private lateinit var Age : EditText
    private lateinit var Address : EditText
    private lateinit var Email : EditText
    private lateinit var Contact : EditText
    private lateinit var db: DBHelper3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_details)


        supportActionBar!!.title = "View Applied Job"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        editV = findViewById(R.id.editV)
        viewV = findViewById(R.id.viewV)
        deleteV = findViewById(R.id.deleteV)

        Code = findViewById(R.id.Code)
        UserName = findViewById(R.id.UserName)
        Qualification = findViewById(R.id.Qualification)
        Age = findViewById(R.id.Age)
        Address = findViewById(R.id.Address)
        Email = findViewById(R.id.Email)
        Contact = findViewById(R.id.Contact)


        db = DBHelper3(this)



        viewV.setOnClickListener {


            val cursor = db.viewdata(Code.text.toString())

            if (cursor?.count == 0) {
                Toast.makeText(this, "Enter your Code correctly to view your data", Toast.LENGTH_SHORT).show()

            } else {
                // val stringBuffer = StringBuffer()
                while (cursor!!.moveToNext()) {
                    val CodeEditText: EditText = findViewById(R.id.Code)
                    CodeEditText.setText(cursor.getString(0))

                    val UserNameEditText: EditText = findViewById(R.id.UserName)
                    UserNameEditText.setText(cursor.getString(1))

                    val QualificationEditText: EditText = findViewById(R.id.Qualification)
                    QualificationEditText.setText(cursor.getString(2))

                    val AgeEditText: EditText = findViewById(R.id.Age)
                    AgeEditText.setText(cursor.getString(3))

                    val AddressEditText: EditText = findViewById(R.id.Address)
                    AddressEditText.setText(cursor.getString(4))

                    val EmailEditText: EditText = findViewById(R.id.Email)
                    EmailEditText.setText(cursor.getString(5))

                    val ContactEditText: EditText = findViewById(R.id.Contact)
                    ContactEditText.setText(cursor.getString(6))
                }

            }
        }



        editV.setOnClickListener {
            val intent = Intent(this, ViewsJob::class.java)
            startActivity(intent)
        }

        deleteV.setOnClickListener {
            val intent = Intent(this, Deletesjob::class.java)
            startActivity(intent)
        }
        /*home.setOnClickListener {
            val intent = Intent(this, MainActivityJS::class.java)
            startActivity(intent)
        }*/
    }
}