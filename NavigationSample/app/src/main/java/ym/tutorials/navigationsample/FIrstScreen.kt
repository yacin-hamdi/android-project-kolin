package ym.tutorials.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FirstScreen(navigateToSecond: (Person) -> Unit){
    val person = Person("", 0)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val name = remember{
            mutableStateOf("")
        }
        val age = remember{ mutableStateOf(10) }

        Text(
            "This is the First Screen",
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.padding(16.dp))
        OutlinedTextField(value = name.value, onValueChange ={
            name.value = it
        } )
        Spacer(modifier = Modifier.padding(8.dp))
        OutlinedTextField(value = age.value.toString(), onValueChange = {
            age.value = it.toInt()  ?: 0
        })

        Button(onClick = {
            person.age = age.value
            person.name = name.value
            navigateToSecond(person)
        }) {
            Text("Go to Second Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstPreview(){
//    FirstScreen{}
}