package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class deleteReview : AppCompatActivity() {

    private lateinit var delD : Button
    //private lateinit var updateD : Button
    private lateinit var idD : EditText

    private lateinit var db: DBHelper2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_review)

        supportActionBar!!.title = "Delete Review"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        delD = findViewById(R.id.delD)
        //updateD = findViewById(R.id.updateD)
        idD = findViewById(R.id.idD)


        db = DBHelper2(this)

        delD.setOnClickListener {
            val success = db.deletedata(idD.text.toString())

            if (success) {
                Toast.makeText(this, "Review deleted successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivityRe::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid Reviw Id", Toast.LENGTH_SHORT).show()
            }
        }

        /*delD.setOnClickListener {
            val intent = Intent(this, MainActivityRe::class.java)
            startActivity(intent)
        }*/
    }
}
