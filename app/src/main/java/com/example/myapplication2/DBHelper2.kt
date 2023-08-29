package com.example.myapplication2


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHelper2(context: Context): SQLiteOpenHelper(context,"reviewdata",null,1) {


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table  reviewdata(name TEXT ,id TEXT primary key,email TEXT,review TEXT)")
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists reviewdata")
    }

    fun insertdata(
        name: String,
        id: String,
        email: String,
        review: String

    ): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("name", name)
        cv.put("id", id)
        cv.put("email", email)
        cv.put("review", review)

        val result = db.insert("reviewdata", null, cv)
        if (result == -1.toLong()) {
            return false
        }
        return true
    }


    fun viewdata(id:String): Cursor? {
        val db = this.writableDatabase
        val query = "SELECT * FROM reviewdata where id = '$id' "
        val cursor = db.rawQuery(query, null)

        return cursor
    }

    fun deletedata(id: String): Boolean {
        val db = this.writableDatabase
        val whereClause = "id = ? "
        val whereArgs = arrayOf(id)
        val result = db.delete("reviewdata", whereClause, whereArgs)
        return result > 0
    }

    fun updateData(
        /*name: String,
        id: String,
        email: String,
        review: String,*/
        id: String,
        newname: String,
        // newid: String,
        newemail: String,
        newreview: String,

        ): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("name", newname)
        //cv.put("id", newid)
        cv.put("email", newemail)
        cv.put("review", newreview)


        val whereClause = "id=?"
        val whereArgs = arrayOf(id)

        val result = db.update("reviewdata", cv, whereClause, whereArgs)
        return result > 0
    }






}

