package com.example.contactsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactsapp.database.does.ContantDoe
import com.example.contactsapp.database.entites.ContantDM

@Database(entities = [ContantDM::class], version = 2)
abstract class MyDataBase: RoomDatabase (){
    companion object{
      private  var myDataBase: MyDataBase?=null
        fun creatDataBase(context: Context)
        {
            myDataBase= Room.databaseBuilder(context, MyDataBase::class.java,"dp")
                .allowMainThreadQueries().fallbackToDestructiveMigration().build()
        }

        fun getDataBase(): MyDataBase{
            return myDataBase!!
        }
    }
    abstract  fun getContantDoe(): ContantDoe
}