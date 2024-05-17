package ym.tutorials.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(
    person:Person,
    navigateToFirst:()->Unit,
    navigateToThird:()->Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            "This is the Second Screen",
            fontSize = 24.sp
            )
        Text(
            text = "Welcome ${person.name}, ${person.age.toString()} yo",
            fontSize = 24.sp
        )

        Button(onClick = {
            navigateToFirst()
        }) {
            Text("Go to Fisrt Screen")
        }
        Button(onClick = {
            navigateToThird()
        }){
            Text("Go to third screen")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun SecondPreview(){
//    SecondScreen("hello", {}, {})
}