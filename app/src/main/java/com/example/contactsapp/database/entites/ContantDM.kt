package com.example.contactsapp.database.entites

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContantDM(
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    @ColumnInfo
    var UserName: String,
    @ColumnInfo
    var Gmail: String,
    @ColumnInfo
    var phoneNumber: String,
    @ColumnInfo
var Imag: String
)
