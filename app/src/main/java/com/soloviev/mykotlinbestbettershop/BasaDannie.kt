package com.soloviev.mykotlinbestbettershop

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BasaDannie(val cont: Context,val factory: SQLiteDatabase.CursorFactory?): SQLiteOpenHelper(cont,"MyShopIsBest", factory,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val creatTableDB = "CREATE TABLE client (id INT PRIMARY KEY, login TEXT,email TEXT,password TEXT)"
        db!!.execSQL(creatTableDB)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS client")
        onCreate(db)
    }

    fun newClient (client: Client){
        val values = ContentValues()
        values.put("login", client.login)
        values.put("email", client.email)
        values.put("password", client.password)

        val db = this.writableDatabase
        db.insert("client", null, values)

        db.close()
    }

    fun  getUser(login: String, password: String): Boolean {
        val db = this.readableDatabase

        val resultat = db.rawQuery("SELECT * FROM client WHERE login = '$login' AND password = '$password'", null)
        return resultat.moveToFirst()
    }

}