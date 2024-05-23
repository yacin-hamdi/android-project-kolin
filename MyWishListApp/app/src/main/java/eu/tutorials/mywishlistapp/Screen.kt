package eu.tutorials.mywishlistapp


sealed class Screen(val route:String){
    object HomeScreen: Screen(route="home_screen")
    object AddScreen: Screen(route="add_screen")
}










































//sealed class Screen(val route:String) {
//    object HomeScreen: Screen("home_screen")
//    object AddScreen: Screen("add_screen")
//}