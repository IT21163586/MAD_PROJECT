package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ViewsJob : AppCompatActivity() {

    private lateinit var savesEdit: Button
    private lateinit var cancelsEdit: Button
    private lateinit var codeE: EditText
    private lateinit var unameEdit: EditText
    private lateinit var educateEdit: EditText
    private lateinit var ageEdit: EditText
    private lateinit var addressEdit: EditText
    private lateinit var emailEdit: EditText
    private lateinit var phoneEdit: EditText
    private lateinit var db: DBHelper3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views_job)


        //Back button in  action bar
        supportActionBar!!.title = "Update Applied Job"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        savesEdit = findViewById(R.id.savesEdit)
        cancelsEdit = findViewById(R.id.cancelsEdit)
        codeE = findViewById(R.id.codeE)
        unameEdit = findViewById(R.id.unameEdit)
        educateEdit = findViewById(R.id.educateEdit)
        ageEdit = findViewById(R.id.ageEdit)
        addressEdit = findViewById(R.id.addressEdit)
        emailEdit = findViewById(R.id.emailEdit)
        phoneEdit = findViewById(R.id.phoneEdit)
        db = DBHelper3(this)

//update the data using update data function using
        savesEdit.setOnClickListener {
            val codetext = codeE.text.toString()
            val unametext = unameEdit.text.toString()
            val educatetext = educateEdit.text.toString()
            val agetext = ageEdit.text.toString()
            val addresstext = addressEdit.text.toString()
            val emailtext = emailEdit.text.toString()
            val phonetext = phoneEdit.text.toString()

            /* if (TextUtils.isEmpty(codetext) || TextUtils.isEmpty(titletext) || TextUtils.isEmpty(categorytext) || TextUtils.isEmpty(salarytext) || TextUtils.isEmpty(qualifitext) || TextUtils.isEmpty(destext) || TextUtils.isEmpty(contacttext)) {
                Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show()
            } else {
*/
            val success = db.updateData(
                codetext,
                unametext,
                educatetext,
                agetext,
                addresstext,
                emailtext,
                phonetext
            )

            if (success) {
                Toast.makeText(this, "Job updated successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Failed to update Job", Toast.LENGTH_SHORT).show()
            }



            cancelsEdit.setOnClickListener {
                val intent = Intent(this, MainActivityJS::class.java)
                startActivity(intent)
            }

            savesEdit.setOnClickListener {
                val intent = Intent(this, MainActivityJS::class.java)
                startActivity(intent)
            }
        }
    }

}