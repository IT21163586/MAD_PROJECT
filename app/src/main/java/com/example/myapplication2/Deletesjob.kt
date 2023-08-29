package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Deletesjob : AppCompatActivity() {

    private lateinit var deleteDel : Button
    //private lateinit var updateD : Button
    private lateinit var codeDelete : EditText

    private lateinit var db: DBHelper3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deletesjob)


        supportActionBar!!.title = "Delete Applied Jobs"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        deleteDel = findViewById(R.id.deleteDel)
        //updateD = findViewById(R.id.updateD)
        codeDelete = findViewById(R.id.codeDelete)


        db = DBHelper3(this)

        deleteDel.setOnClickListener {
            val success = db.deletedata(codeDelete.text.toString())

            if (success) {
                Toast.makeText(this, "Job deleted successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivityJS::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid Job Id", Toast.LENGTH_SHORT).show()
            }
        }

        /*updateD.setOnClickListener {
            val intent = Intent(this, UpdateProfile::class.java)
            startActivity(intent)
        }*/
    }

}