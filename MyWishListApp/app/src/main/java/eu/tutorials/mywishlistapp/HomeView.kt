package eu.tutorials.mywishlistapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.tutorials.mywishlistapp.data.DummyWish
import eu.tutorials.mywishlistapp.data.Wish


@Composable
fun HomeView(){
    val context = LocalContext.current
    val list:MutableList<Wish> = mutableListOf()

    Scaffold(
        topBar = {AppBarView(title = "WishList",  {

            Toast.makeText(context, "button Clicked", Toast.LENGTH_LONG).show()
        })},
        floatingActionButton={
            FloatingActionButton(
                modifier = Modifier.padding(all = 20.dp),
                contentColor = Color.White,
                backgroundColor = Color.Black,
                onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null )

            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)) {
            items(DummyWish.wishList){
                item ->
                WishItem(wish = item) {

                }
            }

        }
    }
}













@Composable
fun WishItem(wish: Wish, onClick: () -> Unit){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        .clickable {
            onClick()
        },
        elevation = 1.dp,
        backgroundColor = Color.White
    ){
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)

        }

    }
}

@Preview(showBackground = true)
@Composable
fun WishItemPreview(){
    val wish = Wish(0, "job", "description")
    WishItem(wish = wish) {

    }
}
