package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivityJS : AppCompatActivity() {

    private lateinit var applynewjob: Button
    private lateinit var viewjob: Button

    private lateinit var db: DBHelper3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_js)


        applynewjob = findViewById(R.id.applynewjob)
        viewjob = findViewById(R.id.viewjob)

        db = DBHelper3(this)

        applynewjob.setOnClickListener {
            val intent = Intent(this, Applyjob::class.java)
            startActivity(intent)
        }
        viewjob.setOnClickListener {
            val intent = Intent(this, ApplyDetails::class.java)
            startActivity(intent)
        }

    }
}