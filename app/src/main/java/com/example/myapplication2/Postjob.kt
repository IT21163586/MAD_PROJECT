package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Postjob : AppCompatActivity() {

    private lateinit var post : Button

    private lateinit var code : EditText
    private lateinit var title : EditText
    private lateinit var category : EditText
    private lateinit var salary : EditText
    private lateinit var qualifications : EditText
    private lateinit var description : EditText
    private lateinit var contact : EditText
    private lateinit var db: DBHelper1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postjob)

        supportActionBar!!.title = "Post Job"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        post = findViewById(R.id.post)

        code = findViewById(R.id.code)
        title = findViewById(R.id.title)
        category = findViewById(R.id.category)
        salary = findViewById(R.id.salary)
        qualifications = findViewById(R.id.qualifications)
        description = findViewById(R.id.description)
        contact = findViewById(R.id.contact)
        db = DBHelper1(this)

        post.setOnClickListener {
            val codetext = code.text.toString()
            val titletext = title.text.toString()
            val categorytext = category.text.toString()
            val salarytext = salary.text.toString()
            val qualificationstext = qualifications.text.toString()
            val desscriptiontext = description.text.toString()
            val contacttext = contact.text.toString()


            val savedata = db.insertdata(codetext,titletext,categorytext,salarytext,qualificationstext,desscriptiontext,contacttext)
            if (TextUtils.isEmpty(codetext) || TextUtils.isEmpty(titletext) || TextUtils.isEmpty(categorytext) || TextUtils.isEmpty(salarytext)|| TextUtils.isEmpty(qualificationstext)|| TextUtils.isEmpty(desscriptiontext)|| TextUtils.isEmpty(contacttext)){
                Toast.makeText(this,"Please fill details", Toast.LENGTH_SHORT).show()
            }
            else{
                if (savedata==true){
                    Toast.makeText(this,"Job posted successfully", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext,JobDetails::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Job Already exists", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}
