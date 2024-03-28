package com.example.lab4.notes_app

import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.ui.platform.LocalContext
import java.io.File
import java.lang.Exception

class NoteModel() {
    var title = ""
    var content = ""
    var datetime = ""

    constructor(title: String, content: String, datetime: String) : this() {
        this.title = title
        this.content = content
        this.datetime = datetime
    }

    constructor(title: String, content: String) : this() {
        this.title = title
        this.content = content
        this.datetime = datetime
    }

    constructor(value: String) : this(){
        var firstBreak = value.indexOfFirst {
            it == '~'
        }
        var lastBreak = value.indexOfLast {it == '~'}
        title = value.substring(0, firstBreak)
        datetime = value.substring(firstBreak+1, lastBreak)
        content = value.substring(lastBreak+1, value.length)
    }

    fun getCombined(): String {
        return "$title~$datetime~$content"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun save(context: Context) : Boolean{
        if (title.isEmpty()){
            Toast.makeText(context, "Please Provide Title", Toast.LENGTH_LONG).show()
            return false
        }
        return try{
            val newfolder = File(context.filesDir, "notes")
            if (!newfolder.exists()){
                newfolder.mkdir()
                Toast.makeText(context, "Directory created", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context, "Directory exists", Toast.LENGTH_LONG).show()
            }
            val file = File(newfolder, Functions().getUniqueId())
//            val output = context.openFileOutput(file.path, Context.MODE_PRIVATE)
//            output.write(getCombined().toByteArray())
//            output.close()
            true
        }catch(e: Exception){
            false
        }
    }
}
