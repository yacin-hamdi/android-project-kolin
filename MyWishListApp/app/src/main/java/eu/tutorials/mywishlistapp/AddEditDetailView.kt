package eu.tutorials.mywishlistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun AddEditDetailView(
    id: Int,
    wishViewModel: WishViewModel,
    navController: NavController
){
    Scaffold(topBar = {
        AppBarView(title =
        if(id != 0) stringResource(id = R.string.add_wish)
        else stringResource(id = R.string.update_wish)
        )
    }) {
        Column(modifier = Modifier.padding(it).wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AddEditDetailPreview(){
    val context = LocalContext.current
    AddEditDetailView(id = 0,
        wishViewModel = WishViewModel(),
        navController = NavController(context))
}