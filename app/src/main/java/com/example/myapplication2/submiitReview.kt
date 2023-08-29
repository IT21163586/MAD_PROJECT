package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class submiitReview : AppCompatActivity() {

    private lateinit var submit1 : Button

    private lateinit var nameS : EditText
    private lateinit var idS : EditText
    private lateinit var emailS : EditText
    private lateinit var revS : EditText

    private lateinit var db:DBHelper2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submiit_review)

        supportActionBar!!.title = "Submit Review"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        submit1 = findViewById(R.id.submit1)

        nameS = findViewById(R.id.nameS)
        idS = findViewById(R.id.idS)
        emailS = findViewById(R.id.emailS)
        revS= findViewById(R.id.revS)
        db = DBHelper2(this)

        submit1.setOnClickListener {
            val sbtext = nameS.text.toString()
            val sidtext = idS.text.toString()
            val emtext = emailS.text.toString()
            val rwtext = revS.text.toString()


            val savedata = db.insertdata(sbtext,sidtext,emtext,rwtext)
            if (TextUtils.isEmpty(sbtext) || TextUtils.isEmpty(sidtext) || TextUtils.isEmpty(emtext)|| TextUtils.isEmpty(rwtext)){
                Toast.makeText(this,"Please fill details", Toast.LENGTH_SHORT).show()
            }
            else{
                if (savedata==true){
                    Toast.makeText(this,"reviewed successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext,MainActivityRe::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"User exit", Toast.LENGTH_SHORT).show()
                }
            }



        }
    }
}
