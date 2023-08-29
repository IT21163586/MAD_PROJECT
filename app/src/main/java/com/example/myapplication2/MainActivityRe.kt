package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivityRe : AppCompatActivity() {

    private lateinit var submit : Button
    private lateinit var yourreview : Button

    private lateinit var db:DBHelper2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_re)

        submit = findViewById(R.id.submit)
        yourreview = findViewById(R.id.yourreview)

        db = DBHelper2(this)

        submit.setOnClickListener {
            val intent = Intent(this, submiitReview::class.java)
            startActivity(intent)
        }
        yourreview.setOnClickListener {
            val intent = Intent(this, yourReview::class.java)
            startActivity(intent)
        }







    }

}
