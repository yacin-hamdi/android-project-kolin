package eu.tutorials.mywishlistapp

import android.graphics.Paint.Style
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import eu.tutorials.mywishlistapp.data.Wish
import kotlinx.coroutines.launch


@Composable
fun AddEditDetailView(
    id: Long,
    wishViewModel: WishViewModel,
    navController: NavController
){

    val snackMessage = remember{
        mutableStateOf("")
    }
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(topBar = {
        AppBarView(title =
        if(id != 0L) stringResource(id = R.string.update_wish)
        else stringResource(id = R.string.add_wish)
        ){navController.navigateUp()}
    },
        scaffoldState = scaffoldState) {
        Column(modifier = Modifier
            .padding(it)
            .wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Spacer(modifier = Modifier.height(10.dp))
            WishTextField(
                label = "title",
                value = wishViewModel.wishTitleState
            ) {
                wishViewModel.onWishTitleChanged(it)
            }
            Spacer(modifier = Modifier.height(10.dp))

            WishTextField(
                label = "Description",
                value = wishViewModel.wishDescriptionState) {
                wishViewModel.onWishDescriptionChanged(it)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                if(wishViewModel.wishTitleState.isNotEmpty() &&
                    wishViewModel.wishDescriptionState.isNotEmpty()){

                    if(id != 0L){

                    }else{
                        wishViewModel.addWish(
                            Wish(
                                title = wishViewModel.wishTitleState,
                                description = wishViewModel.wishDescriptionState
                            )
                        )
                        snackMessage.value = "wish added"


                    }

                }else{
                    snackMessage.value = "Enter field to create a wish"
                }

                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(snackMessage.value)
                    navController.navigateUp()
                }
            }) {
                Text(
                    text = if(id != 0L) stringResource(id = R.string.update_wish)
                            else stringResource(id = R.string.add_wish),
                    style = TextStyle(
                        fontSize = 18.sp
                    ))
            }
        }
    }
}


@Composable
fun WishTextField(
    label: String,
    value: String,
    onChanged: (String)-> Unit
){
    OutlinedTextField(
        value = value, 
        onValueChange = onChanged,
        label = { Text(text = label, color = Color.Black)},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            cursorColor = colorResource(id = R.color.black),
            focusedLabelColor = colorResource(id = R.color.black),
            unfocusedLabelColor = colorResource(id = R.color.black),
            focusedIndicatorColor = colorResource(id = R.color.black),
            unfocusedIndicatorColor = colorResource(id = R.color.black)

        )
    )
}


@Preview(showBackground = true)
@Composable
fun AddEditDetailPreview(){
    val context = LocalContext.current
    AddEditDetailView(id = 0,
        wishViewModel = WishViewModel(),
        navController = NavController(context))
//    WishTextField("text", "text", {})
}