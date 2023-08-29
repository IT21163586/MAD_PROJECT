package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SeekerEmployyeSignUp : AppCompatActivity() {

    private lateinit var signUpSE : Button
    private lateinit var role : EditText
    private lateinit var username : EditText
    private lateinit var userid : EditText
    private lateinit var phone : EditText
    private lateinit var address : EditText
    private lateinit var password :EditText
    private lateinit var repassword :EditText
    private lateinit var db:DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seeker_employye_sign_up)

        signUpSE = findViewById(R.id.signUpSE)
        role = findViewById(R.id.role)
        username = findViewById(R.id.username)
        userid = findViewById(R.id.userid)
        phone = findViewById(R.id.phone)
        address = findViewById(R.id.address)
        password = findViewById(R.id.password)
        repassword = findViewById(R.id.repassword)
        db = DBHelper(this)

//singnup  insertdata function using
        signUpSE.setOnClickListener {
            val rotext = role.text.toString()
            val untext = username.text.toString()
            val uidtext = userid.text.toString()
            val phtext = phone.text.toString()
            val adtext = address.text.toString()
            val pwtext = password.text.toString()
            val repwtext = repassword.text.toString()

            val savedata = db.insertdata(rotext,untext,uidtext,phtext,adtext,pwtext,repwtext)
            if (TextUtils.isEmpty(rotext) || TextUtils.isEmpty(untext) || TextUtils.isEmpty(uidtext) || TextUtils.isEmpty(phtext) || TextUtils.isEmpty(adtext) || TextUtils.isEmpty(pwtext) || TextUtils.isEmpty(repwtext)){
                Toast.makeText(this,"Please fill details",Toast.LENGTH_SHORT).show()
            }
            else{
                if (pwtext.equals(repwtext)){
                    if (savedata==true){
                        Toast.makeText(this,"signup successful",Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext,MainActivitySE::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"User exit",Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this,"password not match",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}