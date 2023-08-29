package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class JobDetails : AppCompatActivity() {


    private lateinit var edit: Button
    private lateinit var view: Button
    private lateinit var delete: Button

    private lateinit var Code: EditText
    private lateinit var Title: EditText
    private lateinit var Category: EditText
    private lateinit var Salary: EditText
    private lateinit var Qualifications: EditText
    private lateinit var Description: EditText
    private lateinit var Contact: EditText
    private lateinit var db: DBHelper1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_details)


        supportActionBar!!.title = "View Job"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        edit = findViewById(R.id.edit)
        view = findViewById(R.id.view)
        delete = findViewById(R.id.delete)

        Code = findViewById(R.id.Code)
        Title = findViewById(R.id.Title)
        Category = findViewById(R.id.Category)
        Salary = findViewById(R.id.Salary)
        Qualifications = findViewById(R.id.Qualifications)
        Description = findViewById(R.id.Description)
        Contact = findViewById(R.id.Contact)


        db = DBHelper1(this)



        view.setOnClickListener {


            val cursor = db.viewdata(Code.text.toString())

            if (cursor?.count == 0) {
                Toast.makeText(
                    this,
                    "Enter your Code correctly to view your data",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                // val stringBuffer = StringBuffer()
                while (cursor!!.moveToNext()) {
                    val CodeEditText: EditText = findViewById(R.id.Code)
                    CodeEditText.setText(cursor.getString(0))

                    val TitleEditText: EditText = findViewById(R.id.Title)
                    TitleEditText.setText(cursor.getString(1))

                    val CategoryEditText: EditText = findViewById(R.id.Category)
                    CategoryEditText.setText(cursor.getString(2))

                    val SalaryEditText: EditText = findViewById(R.id.Salary)
                    SalaryEditText.setText(cursor.getString(3))

                    val QualificationsEditText: EditText = findViewById(R.id.Qualifications)
                    QualificationsEditText.setText(cursor.getString(4))

                    val DescriptionEditText: EditText = findViewById(R.id.Description)
                    DescriptionEditText.setText(cursor.getString(5))

                    val ContactEditText: EditText = findViewById(R.id.Contact)
                    ContactEditText.setText(cursor.getString(6))
                }

            }
        }



        edit.setOnClickListener {
            val intent = Intent(this, ViewJob::class.java)
            startActivity(intent)
        }

        delete.setOnClickListener {
            val intent = Intent(this, Deletejob::class.java)
            startActivity(intent)
        }
        /*home.setOnClickListener {
            val intent = Intent(this, MainActivitySE::class.java)
            startActivity(intent)
        }*/
    }
}
