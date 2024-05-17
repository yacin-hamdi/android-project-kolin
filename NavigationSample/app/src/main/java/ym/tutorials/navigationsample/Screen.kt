package ym.tutorials.navigationsample

sealed class Screen(val route: String) {
    object FirstScreen:Screen("firstScreen")
    object SecondScreen:Screen("secondScreen")
    object ThirdScreen:Screen("thirdScreen")
}