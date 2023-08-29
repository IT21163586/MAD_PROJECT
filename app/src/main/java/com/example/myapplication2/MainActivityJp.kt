package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivityJp : AppCompatActivity() {

    private lateinit var postnewjob: Button
    private lateinit var viewjobs: Button
    //private lateinit var deleteMain: Button

    /*private lateinit var useridL : EditText
    private lateinit var passwordL :EditText*/
    private lateinit var db: DBHelper1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_jp)

        postnewjob = findViewById(R.id.postnewjob)
        viewjobs = findViewById(R.id.viewjobs)
        //deleteMain = findViewById(R.id.deleteMain)

        /* useridL = findViewById(R.id.useridL)
        passwordL = findViewById(R.id.passwordL)*/
        db = DBHelper1(this)

        postnewjob.setOnClickListener {
            val intent = Intent(this, Postjob::class.java)
            startActivity(intent)
        }
        viewjobs.setOnClickListener {
            val intent = Intent(this, JobDetails::class.java)
            startActivity(intent)
        }
        /* deleteMain.setOnClickListener {
             val intent = Intent(this, Deletejob::class.java)
             startActivity(intent)
         }*/

    }
}