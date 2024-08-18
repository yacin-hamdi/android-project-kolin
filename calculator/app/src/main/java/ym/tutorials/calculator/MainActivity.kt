package ym.tutorials.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ym.tutorials.calculator.presentation.CalculatorScreen
import ym.tutorials.calculator.presentation.CalculatorViewModel
import ym.tutorials.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = CalculatorViewModel()
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                CalculatorScreen(viewModel = viewModel)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val viewModel = CalculatorViewModel()
    CalculatorTheme {
        CalculatorScreen(viewModel = viewModel)
    }
}