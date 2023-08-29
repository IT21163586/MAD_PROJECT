package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Dashboard : AppCompatActivity() {
    private lateinit var postnewjob: Button
    private lateinit var review: Button

    private lateinit var jobsearch: Button



    private lateinit var profile: Button
    private lateinit var Logout: Button


    //private lateinit var deleteMain: Button

    /*private lateinit var useridL : EditText
    private lateinit var passwordL :EditText*/
    private lateinit var db: DBHelper1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)


        postnewjob = findViewById(R.id.postnewjob)
        review = findViewById(R.id.review)
        jobsearch = findViewById(R.id.jobsearch)


        profile = findViewById(R.id.profile)
        Logout = findViewById(R.id.Logout)
        //deleteMain = findViewById(R.id.deleteMain)

        /* useridL = findViewById(R.id.useridL)
        passwordL = findViewById(R.id.passwordL)*/
        db = DBHelper1(this)

        postnewjob.setOnClickListener {
            val intent = Intent(this, MainActivityJp::class.java)
            startActivity(intent)
        }
        review.setOnClickListener {
            val intent = Intent(this, MainActivityRe::class.java)
            startActivity(intent)
        }

        profile.setOnClickListener {
            val intent = Intent(this, ViewProfile::class.java)
            startActivity(intent)
        }
        jobsearch.setOnClickListener {
            val intent = Intent(this, MainActivityJS::class.java)
            startActivity(intent)
        }

        Logout.setOnClickListener {
            val intent = Intent(this, MainActivitySE::class.java)
            startActivity(intent)
        }
        /* deleteMain.setOnClickListener {
             val intent = Intent(this, Deletejob::class.java)
             startActivity(intent)
         }*/

    }
}