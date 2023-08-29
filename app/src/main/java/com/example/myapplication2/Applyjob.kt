package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Applyjob : AppCompatActivity() {

    private lateinit var apply : Button

    private lateinit var code : EditText
    private lateinit var uname : EditText
    private lateinit var educate : EditText
    private lateinit var age : EditText
    private lateinit var address : EditText
    private lateinit var email : EditText
    private lateinit var phone : EditText
    private lateinit var db: DBHelper3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_applyjob)

        supportActionBar!!.title = "Apply Job"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        apply = findViewById(R.id.apply)

        code = findViewById(R.id.code)
        uname = findViewById(R.id.uname)
        educate = findViewById(R.id.educate)
        age = findViewById(R.id.age)
        address = findViewById(R.id.address)
        email = findViewById(R.id.email)
        phone = findViewById(R.id.phone)
        db = DBHelper3(this)

        apply.setOnClickListener {
            val codetext = code.text.toString()
            val unametext = uname.text.toString()
            val educatetext = educate.text.toString()
            val agetext = age.text.toString()
            val addresstext = address.text.toString()
            val emailtext = email.text.toString()
            val phonetext = phone.text.toString()


            val savedata = db.insertdata(codetext,unametext,educatetext,agetext,addresstext,emailtext,phonetext)
            if (TextUtils.isEmpty(codetext) || TextUtils.isEmpty(unametext) || TextUtils.isEmpty(educatetext) || TextUtils.isEmpty(agetext)|| TextUtils.isEmpty(addresstext)|| TextUtils.isEmpty(emailtext)|| TextUtils.isEmpty(phonetext)){
                Toast.makeText(this,"Please fill details", Toast.LENGTH_SHORT).show()
            }
            else{
                if (savedata==true){
                    Toast.makeText(this,"Job Applied successfully", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext,ApplyDetails::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Applied this job already", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

}