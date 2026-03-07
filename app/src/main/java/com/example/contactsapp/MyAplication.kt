package com.example.contactsapp

import android.app.Application
import com.example.contactsapp.database.MyDataBase

class MyAplication: Application(){
    override fun onCreate() {
        super.onCreate()
        MyDataBase.creatDataBase(this)
    }
}