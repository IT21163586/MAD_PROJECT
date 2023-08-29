package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class updateReview : AppCompatActivity() {

    private lateinit var saveU: Button
    private lateinit var cancelU: Button
    private lateinit var idU: EditText
    private lateinit var nameU: EditText
    private lateinit var emailU: EditText
    private lateinit var revU: EditText

    private lateinit var db: DBHelper2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_review)


        //Back button in  action bar
        supportActionBar!!.title = "Update Review"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        saveU = findViewById(R.id.saveU)
        cancelU = findViewById(R.id.cancelU)
        idU = findViewById(R.id.idU)
        nameU = findViewById(R.id.nameU)
        emailU = findViewById(R.id.emailU)
        revU = findViewById(R.id.revU)

        db = DBHelper2(this)

//update the data using update data function using
        saveU.setOnClickListener {
            val idtext = idU.text.toString()
            val nametext = nameU.text.toString()
            val emailtext = emailU.text.toString()
            val rewtext = revU.text.toString()

            /* if (TextUtils.isEmpty(codetext) || TextUtils.isEmpty(titletext) || TextUtils.isEmpty(categorytext) || TextUtils.isEmpty(salarytext) || TextUtils.isEmpty(qualifitext) || TextUtils.isEmpty(destext) || TextUtils.isEmpty(contacttext)) {
                Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show()
            } else {
*/
            val success = db.updateData(
                idtext,
                nametext,
                emailtext,
                rewtext
            )

            if (success) {
                Toast.makeText(this, "Review updated successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Failed to update Review", Toast.LENGTH_SHORT).show()
            }



            cancelU.setOnClickListener {
                val intent = Intent(this, MainActivityRe::class.java)
                startActivity(intent)
            }


        }
    }
}
