package com.example.myapplication2


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper3(context: Context) :SQLiteOpenHelper(context,"ApplyDetails",null,1){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table  ApplyDetails(uname TEXT, code TEXT primary key,educate TEXT,age TEXT," +
                "address TEXT, email TEXT, phone TEXT)")
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists ApplyDetails")
    }

    fun insertdata(
        code:String,
        uname: String,
        educate: String,
        age: String,
        address: String,
        email: String,
        phone: String
    ): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("code", code)
        cv.put("uname", uname)
        cv.put("educate", educate)
        cv.put("age", age)
        cv.put("address", address)
        cv.put("email", email)
        cv.put("phone", phone)

        val result = db.insert("ApplyDetails", null, cv)
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
        val query = "SELECT * FROM ApplyDetails where code = '$code' "
        val cursor = db.rawQuery(query, null)

        return cursor
    }

    fun deletedata(code: String): Boolean {
        val db = this.writableDatabase
        val whereClause = "code = ?"
        val whereArgs = arrayOf(code)
        val result = db.delete("ApplyDetails", whereClause, whereArgs)
        return result > 0
    }

    fun updateData(
        code: String,
        newuname: String,
        neweducate: String,
        newage: String,
        newaddress: String,
        newemail: String,
        newphone: String,

        ): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("uname", newuname)
        cv.put("educate", neweducate)
        cv.put("age",newage)
        cv.put("address", newaddress)
        cv.put("email", newemail)
        cv.put("phone", newphone)


        val whereClause = "code=?"
        val whereArgs = arrayOf(code)

        //val whereArgs = arrayOf(code,jobtitle,category,salary,qualifications,description,contact)
        val result = db.update("ApplyDetails", cv, whereClause, whereArgs)
        return result > 0
    }




}