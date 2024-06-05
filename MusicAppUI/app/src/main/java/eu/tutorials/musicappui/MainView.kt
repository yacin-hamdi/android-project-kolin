package eu.tutorials.musicappui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import eu.tutorials.musicappui.ui.theme.AccountView
import eu.tutorials.musicappui.ui.theme.Home
import eu.tutorials.musicappui.ui.theme.SubscriptionView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(){
    val scaffoldState:ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()
    val mainViewModel: MainViewModel = viewModel()
    val controller: NavController = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val currentScreen = remember{
        mainViewModel.currentScreen.value
    }
    val title = remember{
        mutableStateOf(currentScreen.title)
    }

    val dialogOpen = remember{
        mutableStateOf(false)
    }

    val bottomBar: @Composable () -> Unit = {
        if(currentScreen is Screen.DrawerScreen || currentScreen == Screen.BottomScreen.Home){
            BottomNavigation(Modifier.wrapContentSize()) {
                screensInBottom.forEach{
                    item ->
                    BottomNavigationItem(
                        selected = currentRoute == item.bRoute,
                        onClick = { controller.navigate(item.bRoute)},
                        icon = {
                            Icon(contentDescription = item.bTitle,
                                painter = painterResource(id = item.icon))
                        },
                        label = {
                            Text(text = item.bTitle)
                        },
                        selectedContentColor = Color.Red,
                        unselectedContentColor = Color.Black)
                }
            }
        }
    }

    Scaffold(
        bottomBar = bottomBar,
        topBar = {
            TopAppBar(
                title = { Text(text = title.value)},
                navigationIcon = {IconButton(onClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }) {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Menu")

                }})
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            LazyColumn (modifier = Modifier.padding(16.dp)){
                items(screensInDrawer){
                    item->
                    DrawerItem(selected = currentRoute == item.dRoute, item = item){
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                        if(item.dRoute == "add_account"){
                            dialogOpen.value = true
                        }else{
                            controller.navigate(item.dRoute)
                            title.value = item.dTitle
                        }
                    }

                }
            }
        }

    ) {
        Navigation(
            navController = controller,
            viewModel = mainViewModel,
            pd=it)

        AccountDialog(dialogOpen = dialogOpen)

    }
}

@Composable
fun DrawerItem(
    selected: Boolean,
    item: Screen.DrawerScreen,
    onDrawerItemClicked: () -> Unit
){
    val background = if(selected) Color.DarkGray else Color.White

    Row (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .background(background)
            .clickable {
                onDrawerItemClicked()
            }
    ){
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.dTitle
        )
        Text(
            text = item.dTitle,
            style = MaterialTheme.typography.h5
        )
    }
}

@Composable
fun Navigation(navController: NavController,
               viewModel: MainViewModel,
               pd:PaddingValues){

    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.DrawerScreen.Account.route,
        modifier = Modifier.padding(pd)
    ) {

        composable(route = Screen.DrawerScreen.Account.route){
            AccountView()
        }
        composable(route = Screen.DrawerScreen.Subscription.route){
            SubscriptionView()
        }

        composable(route = Screen.BottomScreen.Home.route){
            Home()
        }

        composable(route = Screen.BottomScreen.Browse.route){
            BrowseScreen()
        }

        composable(route = Screen.BottomScreen.Library.route){

        }

    }

}