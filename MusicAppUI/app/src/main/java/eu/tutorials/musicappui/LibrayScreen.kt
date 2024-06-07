package eu.tutorials.musicappui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun LibraryScreen(){

    LazyColumn(modifier = Modifier
        .fillMaxSize()) {
        items(libraries){
            lib->
            LibraryRow(lib.icon, lib.name)
        }
    }
}

@Composable
fun LibraryRow(icon: Int, name: String){
    Row(modifier = Modifier.padding(16.dp)) {
        Icon(modifier = Modifier.padding(end = 8.dp),
            painter = painterResource(id = icon),
            contentDescription = name)
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = name)
            Icon(modifier = Modifier.padding(end=3.dp),
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "")
        }



    }
    Divider()

}

@Composable
@Preview(showBackground = true)
fun LibraryScreenPreview(){
    LibraryScreen()
}