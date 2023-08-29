package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class yourReview : AppCompatActivity() {

    private lateinit var EditV : Button
    private lateinit var viewV : Button
    private lateinit var delV : Button

    private lateinit var db:DBHelper2
    private lateinit var idV : EditText
    private lateinit var nameV : EditText
    private lateinit var emailV : EditText
    private lateinit var revV : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_review)

        supportActionBar!!.title = "Reviews"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        EditV = findViewById(R.id.EditV)
        viewV = findViewById(R.id.viewV)
        delV = findViewById(R.id.delV)

        nameV = findViewById(R.id.nameV)
        idV = findViewById(R.id.idV)
        emailV = findViewById(R.id.emailV)
        revV= findViewById(R.id.revV)


        db = DBHelper2(this)



        viewV.setOnClickListener {
            //val x = userid.text.toString()
            //val password = passwordL.text.toString()
            val cursor = db.viewdata(idV.text.toString())

            if (cursor?.count == 0) {
                Toast.makeText(this, "Enter your id no correctly view your data", Toast.LENGTH_SHORT).show()

            } else {
                val stringBuffer = StringBuffer()
                while (cursor!!.moveToNext()) {
                    val nameEditText: EditText = findViewById(R.id.nameV)
                    nameEditText.setText(cursor.getString(0))

                    val idEditText: EditText = findViewById(R.id.idV)
                    idEditText.setText(cursor.getString(1))

                    val emailEditText: EditText = findViewById(R.id.emailV)
                    emailEditText.setText(cursor.getString(2))

                    val reviewEditText: EditText = findViewById(R.id.revV)
                    reviewEditText.setText(cursor.getString(3))
                }

            }
        }



        EditV.setOnClickListener {
            val intent = Intent(this, updateReview::class.java)
            startActivity(intent)
        }

        delV.setOnClickListener {
            val intent = Intent(this, deleteReview::class.java)
            startActivity(intent)
        }



    }
}