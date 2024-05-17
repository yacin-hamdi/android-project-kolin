package ym.tutorials.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ym.tutorials.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}


@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.FirstScreen.route
        )
    {
        composable(Screen.FirstScreen.route){
            FirstScreen {
                navController.currentBackStackEntry?.savedStateHandle?.set("person", it)
                navController.navigate(Screen.SecondScreen.route)
            }

        }

        composable(Screen.SecondScreen.route) {
            val person = navController.previousBackStackEntry?.savedStateHandle?.get<Person>("person")?: Person("", 0)
            SecondScreen( person, {
                navController.navigate(Screen.FirstScreen.route)
            },{
                navController.navigate("thirdscreen")
            })
        }

//        composable("thirdscreen"){
//            ThirdScreen {
//                navController.navigate("firstscreen")
//            }
//        }

    }

}





