package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivitySE : AppCompatActivity() {
    private lateinit var jobSeeker : Button
    private lateinit var employee : Button
    private lateinit var signIn : Button
    private lateinit var signUp : Button
    private lateinit var useridL : EditText
    private lateinit var passwordL :EditText
    private lateinit var db:DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_se)

        jobSeeker = findViewById(R.id.jobSeeker)
        employee = findViewById(R.id.employee)
        signIn = findViewById(R.id.signIn)
        signUp = findViewById(R.id.signUp)
        useridL = findViewById(R.id.useridL)
        passwordL = findViewById(R.id.passwordL)
        db = DBHelper(this)

        jobSeeker.setOnClickListener {
            val intent = Intent(this, SeekerEmployyeSignUp::class.java)
            startActivity(intent)
        }
        employee.setOnClickListener {
            val intent = Intent(this, SeekerEmployyeSignUp::class.java)
            startActivity(intent)
        }
        signUp.setOnClickListener {
            val intent = Intent(this, SeekerEmployyeSignUp::class.java)
            startActivity(intent)
        }

//check userid and password using checkuserpass function
        signIn.setOnClickListener {
            val uidtext = useridL.text.toString()
            val pwtext = passwordL.text.toString()
            if (TextUtils.isEmpty(uidtext)||TextUtils.isEmpty(pwtext)){
                Toast.makeText(this,"Add userid & password",Toast.LENGTH_SHORT).show()
            }
            else{
                val ckuser =  db.checkuserpass(uidtext,pwtext)
                if(ckuser==true){
                    Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext,Dashboard::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Wrong username & password ",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
