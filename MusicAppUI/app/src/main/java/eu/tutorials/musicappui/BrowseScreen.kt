package eu.tutorials.musicappui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun BrowseScreen(){
    val categories = listOf("Hits", "Happy", "Workout", "Running", "TGIF", "Yoga")

    LazyVerticalGrid(columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()) {
        items(categories){
            Card(modifier = Modifier
                .padding(16.dp)
                .size(200.dp),
                border = BorderStroke(3.dp, color = Color.DarkGray)
                ){
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = it)
                }

            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun BrowseScreenPreview(){
    BrowseScreen()
}