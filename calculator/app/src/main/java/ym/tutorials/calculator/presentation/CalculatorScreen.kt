package ym.tutorials.calculator.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ym.tutorials.calculator.ui.theme.CalculatorTheme

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .weight(0.8f)
                .background(Color.Gray)
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = viewModel.number1,
                fontSize = 20.sp,
                modifier = Modifier
//                    .align(Alignment.BottomEnd)
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = viewModel.opState,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = viewModel.number2,
                fontSize = 20.sp,
            )

            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "= ${viewModel.resultState}",
                fontSize = 20.sp
            )
        }


        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            contentPadding = PaddingValues(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .weight(1f)) {
            items(testList){item ->
                GridItem(
                    item = item,
                    onButtonClicked = {
                        println(item)
                        viewModel.onEvent(item)
                    }
                )
            }
        }

    }
}

@Composable
fun GridItem(
    item: String,
    onButtonClicked:() -> Unit){
    Button(
        onClick = {
            onButtonClicked()
        },
        shape = CircleShape,
        modifier = Modifier.size(100.dp)
    ) {
        Text(
            text = item,
            fontSize = 20.sp)
    }

}



@Preview(showBackground = true)
@Composable
fun CalculatorScreenPreview(){
    val viewModel = CalculatorViewModel()
    CalculatorTheme{
        CalculatorScreen(viewModel = viewModel)
    }
}


private val testList = listOf(
    "7", "8", "9", "/",
    "4", "5", "6", "x",
    "1", "2", "3", "-",
    "0", ".", "=", "+"
)