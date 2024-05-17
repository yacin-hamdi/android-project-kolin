package eu.tutorials.myFirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.times
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import eu.tutorials.myFirstapp.ui.theme.MyFirstAppTheme
import kotlin.math.roundToInt
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    UnitConverter()


                }
            }
        }
    }

}


@Composable
fun UnitConverter(){

    var inputValue by remember { mutableStateOf("1") }
    var outputValue by remember{ mutableStateOf("")}
    var inputUnit by remember{ mutableStateOf("Meters") }
    var outputUnit by remember{ mutableStateOf("Meters") }
    var iExpanded by remember{ mutableStateOf(false) }
    var oExpanded by remember{ mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(1.00) }
    val oConversionFactor = remember { mutableStateOf(1.00) }

    fun convertUnits(){
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        outputValue = ((inputValueDouble * conversionFactor.value * 100.0 / oConversionFactor.value).roundToInt() / 100.0).toString()
    }

    Column(
        modifier=Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text(text="unit converter",
            style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier=Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue, onValueChange = {
                inputValue = it
                convertUnits()
            },
            label={Text("Enter Value")})
        Spacer(modifier=Modifier.height(16.dp))
        Row{
            Box{
                Button(onClick = {
                    iExpanded = true
                }) {
                    Text(inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }

                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(
                        text = {Text("Centimeters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Centimeters"
                            conversionFactor.value = 0.01

                            convertUnits()

                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Meters"

                            conversionFactor.value = 1.0
                            convertUnits()                        }
                    )

                    DropdownMenuItem(
                        text = {Text("Feet")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Feet"

                            conversionFactor.value = 0.3048

                            convertUnits()


                }
                    )

                    DropdownMenuItem(
                        text = {Text("Millimeters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Millimeters"

                            conversionFactor.value = 0.001
                            convertUnits()
                        }
                    )

                }
            }
            Spacer(modifier=Modifier.width(16.dp))
            Box{
                Button(onClick = {
                    oExpanded = true
                }) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }

                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(
                        text = {Text("Centimeters")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Centimeters"
                            oConversionFactor.value = 0.01

                            convertUnits()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Meters"

                            oConversionFactor.value = 1.00
                            convertUnits()                        }
                    )

                    DropdownMenuItem(
                        text = {Text("Feet")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Feet"

                            oConversionFactor.value = 0.3048

                            convertUnits()
                        }
                    )

                    DropdownMenuItem(
                        text = {Text("Millimeters")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Millimeters"

                            oConversionFactor.value = 0.001
                            convertUnits()
                        }
                    )
                }


            }


        }
        Spacer(modifier=Modifier.height(16.dp))
        Text(text="result: $outputValue $outputUnit",
            style = MaterialTheme.typography.headlineMedium)

    }
}

@Preview(showBackground=true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}






//@Composable
//fun CaptainGame(){
//    val treasuresFound = remember {
//        mutableIntStateOf(0)
//    }
//
//    val direction = remember {
//        mutableStateOf("North")
//    }
//
//    val stormOrTreasure = remember{
//        mutableStateOf("")
//    }
//
//    Column {
//        Text(text="Treasure Found: ${treasuresFound.intValue}")
//        Text(text="Current Direction: ${direction.value}")
//
//        Button(onClick = {
//            direction.value = "East"
//            if(Random.nextBoolean()){
//                treasuresFound.intValue += 1
//                stormOrTreasure.value = "Found a Treasure"
//            }else{
//                stormOrTreasure.value = "Storm Ahead!"
//            }
//        }) {
//            Text(text="Sail East")
//        }
//
//        Button(onClick={
//            direction.value = "West"
//            if(Random.nextBoolean()){
//                treasuresFound.intValue += 1
//                stormOrTreasure.value = "Found a Treasure"
//            }else{
//                stormOrTreasure.value = "Storm Ahead!"
//            }
//        }){
//            Text(text="Sail West")
//        }
//
//        Button(onClick = {
//            direction.value="North"
//            if(Random.nextBoolean()){
//                treasuresFound.intValue += 1
//                stormOrTreasure.value ="Found a Treasure"
//            }else{
//                stormOrTreasure.value = "Storm Ahead!"
//            }
//        }) {
//            Text(text="Sail North")
//        }
//
//        Button(onClick={
//            direction.value = "South"
//            if(Random.nextBoolean()){
//                treasuresFound.intValue += 1
//                stormOrTreasure.value = "Found a Treasure"
//            }else{
//                stormOrTreasure.value = "Storm Ahead!"
//            }
//        }){
//            Text(text="Sail South")
//        }
//
//        Text(text=stormOrTreasure.value)
//
//
//    }
//}