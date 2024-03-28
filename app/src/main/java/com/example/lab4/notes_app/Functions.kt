package com.example.lab4.notes_app
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import java.io.File
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Functions {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getUniqueId():String{
        var localdatetime = LocalDateTime.now()
        var datetime = localdatetime.toString().replace(":", "").replace("-", "").replace(".", "")
        return datetime;
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDateTime():String{
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
    }
}