package com.example.myapplication2

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):SQLiteOpenHelper(context,"Userdata",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table  Userdata(role TEXT , username TEXT ,userid TEXT primary key,phone TEXT,address TEXT , password TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists Userdata")
    }
//insert data
    fun insertdata(
        role:String,
        username: String,
        userid: String,
        phone: String,
        address:String,
        password: String,
        repassword: String
    ): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("Role", role)
        cv.put("Username", username)
        cv.put("Userid", userid)
        cv.put("Phone", phone)
        cv.put("Address", address)
        cv.put("Password", password)

        val result = db.insert("Userdata", null, cv)
        if (result == -1.toLong()) {
            return false
        }
        return true
    }
    fun checkuserpass(userid: String, password: String): Boolean {
        val db = this.writableDatabase
        val query = "select *  from Userdata where userid = '$userid' and password = '$password'"
        val cursor = db.rawQuery(query, null)
        if (cursor.count <= 0) {
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }
//view data using userid
    fun viewdata(userid:String): Cursor? {
        val db = this.writableDatabase
        val query = "SELECT * FROM Userdata where userid = '$userid' "
        val cursor = db.rawQuery(query, null)
        return cursor
    }
//delete data using userid and password
    fun deletedata(userid: String, password: String): Boolean {
        val db = this.writableDatabase
        val whereClause = "userid = ? AND password = ?"
        val whereArgs = arrayOf(userid, password)
        val result = db.delete("Userdata", whereClause, whereArgs)
        return result > 0
    }
//update data using userid
    fun updateData(
        userid: String,
        newRole: String,
        newUsername: String,
        newPhone: String,
        newAddress: String,
        newPassword: String
    ): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("role", newRole)
        cv.put("username", newUsername)
        cv.put("phone", newPhone)
        cv.put("address", newAddress)
        cv.put("password", newPassword)

        val whereClause = "userid=?"
        val whereArgs = arrayOf(userid)

        val result = db.update("Userdata", cv, whereClause, whereArgs)
        return result > 0
    }

}
