package eu.tutorials.musicappui

import androidx.annotation.DrawableRes

sealed class Screen(val title: String, val route: String) {

    sealed class DrawerScreen(val dTitle: String,
                              val dRoute: String,
                              @DrawableRes val icon: Int): Screen(dTitle, dRoute){
        object Account: DrawerScreen(
            dTitle = "Account",
            dRoute = "account",
            icon = R.drawable.ic_account
        )

        object Subscription: DrawerScreen(
            dTitle = "Subscription",
            dRoute = "subscribe",
            icon = R.drawable.ic_subscribe
        )

        object AddAccount: DrawerScreen(
            dTitle = "Add Account",
            dRoute = "add_account",
            icon = R.drawable.baseline_person_add_alt_1_24
        )
    }
}