package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Deletejob : AppCompatActivity() {

    private lateinit var deleteD : Button
    //private lateinit var updateD : Button
    private lateinit var codeD : EditText

    private lateinit var db: DBHelper1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deletejob)

        supportActionBar!!.title = "Delete Job"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        deleteD = findViewById(R.id.deleteD)
        //updateD = findViewById(R.id.updateD)
        codeD = findViewById(R.id.codeD)


        db = DBHelper1(this)

        deleteD.setOnClickListener {
            val success = db.deletedata(codeD.text.toString())

            if (success) {
                Toast.makeText(this, "Job deleted successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivitySE::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid Job Id", Toast.LENGTH_SHORT).show()
            }
        }
    }
}