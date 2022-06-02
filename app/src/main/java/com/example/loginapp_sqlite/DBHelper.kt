package com.example.loginapp_sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (context: Context):SQLiteOpenHelper(context, dbname, factory, version){

    override fun onCreate(db: SQLiteDatabase?) {
//        val query="create table user(id integer primary key autoincrement,"+"name varchar(30),email varchar(100),password varchar(20))"
        db?.execSQL("create table user(id integer primary key autoincrement,"+"name varchar(30),email varchar(100),password varchar(20))")

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
    fun insertUserData(name:String,email:String,password:String) {
        val db:SQLiteDatabase = writableDatabase
        val values:ContentValues= ContentValues()
        values.put("name",name)
        values.put("email",email)
        values.put("password",password)
        db.insert("user",null,values)
        db.close()
    }
    fun userPresent(email: String,password: String):Boolean{
        val db=writableDatabase
        val query="select * from user where email = '$email' and password = '$password'"
        val cursor=db.rawQuery(query,null)
        if(cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }
    companion object{
        internal const val dbname = "userDB"
        internal val factory = null
        internal const val version = 1

    }
//class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
//    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
//    override fun onCreate(db: SQLiteDatabase?) {
//        val query = ("CREATE TABLE " + TABLE_NAME + " ("
//                + ID_COL + " INTEGER PRIMARY KEY, " +
//                NAME_COL + " TEXT," + EMAIL_COL +"TEXT"+
//                PWD_COL + " TEXT" + ")")
//        db?.execSQL(query)
//    }
//    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
//        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
//        onCreate(db)
//    }
//
//    fun addUser(name : String,email : String,password : String ){
//        val values = ContentValues()
//        values.put(NAME_COL,name)
//        values.put(EMAIL_COL,email)
//        values.put(PWD_COL,password)
//        val db = this.writableDatabase
//        db.insert(TABLE_NAME, null, values)
//        db.close()
//    }
//    fun userPresent(email: String,password: String):Boolean{
//        val db=writableDatabase
//        val query="select * from $TABLE_NAME where $EMAIL_COL = $email and $PWD_COL = $password"
//        val cursor=db.rawQuery(query,null)
//        if(cursor.count<=0){
//            cursor.close()
//            return false
//        }
//        cursor.close()
//        return true
//    }
//
//    companion object{
//        private val DATABASE_NAME = "USER"
//        private val DATABASE_VERSION = 1
//        val TABLE_NAME = "user_table"
//        val ID_COL = "id"
//        val NAME_COL = "name"
//        val EMAIL_COL = "email"
//        val PWD_COL = "password"
//    }
}