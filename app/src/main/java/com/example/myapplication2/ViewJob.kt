package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ViewJob : AppCompatActivity() {

    private lateinit var saveEdit: Button
    private lateinit var cancelEdit: Button
    private lateinit var codeEdit: EditText
    private lateinit var titleEdit: EditText
    private lateinit var categoryEdit: EditText
    private lateinit var salaryEdit: EditText
    private lateinit var qualificationsEdit: EditText
    private lateinit var descriptionEdit: EditText
    private lateinit var contactEdit: EditText
    private lateinit var db: DBHelper1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_job)

        //Back button in  action bar
        supportActionBar!!.title = "Update Job"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        saveEdit = findViewById(R.id.saveEdit)
        cancelEdit = findViewById(R.id.cancelEdit)
        codeEdit = findViewById(R.id.codeEdit)
        titleEdit = findViewById(R.id.titleEdit)
        categoryEdit = findViewById(R.id.categoryEdit)
        salaryEdit = findViewById(R.id.salaryEdit)
        qualificationsEdit = findViewById(R.id.qualificationsEdit)
        descriptionEdit = findViewById(R.id.descriptionEdit)
        contactEdit = findViewById(R.id.contactEdit)
        db = DBHelper1(this)

//update the data using update data function using
        saveEdit.setOnClickListener {
            val codetext = codeEdit.text.toString()
            val titletext = titleEdit.text.toString()
            val categorytext = categoryEdit.text.toString()
            val salarytext = salaryEdit.text.toString()
            val qualifitext = qualificationsEdit.text.toString()
            val destext = descriptionEdit.text.toString()
            val contacttext = contactEdit.text.toString()

            /* if (TextUtils.isEmpty(codetext) || TextUtils.isEmpty(titletext) || TextUtils.isEmpty(categorytext) || TextUtils.isEmpty(salarytext) || TextUtils.isEmpty(qualifitext) || TextUtils.isEmpty(destext) || TextUtils.isEmpty(contacttext)) {
                Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show()
            } else {
*/
            val success = db.updateData(
                codetext,
                titletext,
                categorytext,
                salarytext,
                qualifitext,
                destext,
                contacttext
            )

            if (success) {
                Toast.makeText(this, "Job updated successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Failed to update Job", Toast.LENGTH_SHORT).show()
            }



            cancelEdit.setOnClickListener {
                val intent = Intent(this, Dashboard::class.java)
                startActivity(intent)
            }

            saveEdit.setOnClickListener {
                val intent = Intent(this, Dashboard::class.java)
                startActivity(intent)
            }
        }
    }
}
