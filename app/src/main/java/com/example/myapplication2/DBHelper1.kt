package com.example.myapplication2

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper1(context: Context):SQLiteOpenHelper(context,"JobDetails",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table  JobDetails(jobtitle TEXT, code TEXT primary key,category TEXT,salary TEXT," +
                "qualifications TEXT, description TEXT, contact TEXT)")
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists JobDetails")
    }

    fun insertdata(
        code:String,
        jobtitle: String,
        category: String,
        salary: String,
        qualifications: String,
        description: String,
        contact: String
    ): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("code", code)
        cv.put("Jobtitle", jobtitle)
        cv.put("Category", category)
        cv.put("Salary", salary)
        cv.put("Qualifications", qualifications)
        cv.put("Description", description)
        cv.put("Contact", contact)

        val result = db.insert("JobDetails", null, cv)
        if (result == -1.toLong()) {
            return false
        }
        return true
    }

    /*fun checkuserpass(userid: String, password: String): Boolean {
        val db = this.writableDatabase
        val query = "select *  from Userdata where userid = '$userid' and password = '$password'"
        val cursor = db.rawQuery(query, null)
        if (cursor.count <= 0) {
            cursor.close()
            return false
        }
        cursor.close()
        return true

    }*/


    fun viewdata(code:String): Cursor? {
        val db = this.writableDatabase
        val query = "SELECT * FROM JobDetails where code = '$code' "
        val cursor = db.rawQuery(query, null)

        return cursor
    }

    fun deletedata(code: String): Boolean {
        val db = this.writableDatabase
        val whereClause = "code = ?"
        val whereArgs = arrayOf(code)
        val result = db.delete("JobDetails", whereClause, whereArgs)
        return result > 0
    }

    fun updateData(
        /* code: String,
         jobtitle: String,
         category: String,
         salary: String,
         qualifications: String,
         description: String,
         contact: String,*/
        code: String,
        newjobtitle: String,
        newcategory: String,
        newsalary: String,
        newqualifications: String,
        newdescription: String,
        newcontact: String,

        ): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("jobtitle", newjobtitle)
        cv.put("category", newcategory)
        cv.put("salary", newsalary)
        cv.put("qualifications", newqualifications)
        cv.put("description", newdescription)
        cv.put("contact", newcontact)


        val whereClause = "code=?"
        val whereArgs = arrayOf(code)

        //val whereArgs = arrayOf(code,jobtitle,category,salary,qualifications,description,contact)
        val result = db.update("JobDetails", cv, whereClause, whereArgs)
        return result > 0
    }






}






























