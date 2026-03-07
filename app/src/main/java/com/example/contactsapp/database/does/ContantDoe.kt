package com.example.contactsapp.database.does

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.contactsapp.database.entites.ContantDM

@Dao
interface ContantDoe {
    @Insert
    fun addUser(contantDM: ContantDM)
    @Delete
    fun deleteUser(contantDM: ContantDM)
    @Query("select * from contantdm")
    fun getAllUser(): List<ContantDM>

    @Query("select * from contantdm where Id=(select Max(Id) from ContantDM)")
    fun getMaxId(): ContantDM

}