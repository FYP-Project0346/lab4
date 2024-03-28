package com.example.lab4.notes_app

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

class Task3_notes {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Display(nav: NavController, context: Context = LocalContext.current){
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "Keep Notes") })
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    nav.navigate("/add-note")
                }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Note")
                }
            }
        ) {
            Column(
                modifier = Modifier.padding(it)
            ) {
                    LazyColumn(content = {
                        items(5){
                            ListItem(headlineContent = { Text(text = "List No: ${it}") })
                        }
                    })
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Task3_notesPreview(){
    Task3_notes().Display(nav = NavController(LocalContext.current))
}