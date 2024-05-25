package eu.tutorials.mywishlistapp

import android.app.Person
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.tutorials.mywishlistapp.data.Wish
import eu.tutorials.mywishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository
):ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChanged(newTitle: String){
        wishTitleState = newTitle
    }

    fun onWishDescriptionChanged(newDescription: String){
        wishDescriptionState = newDescription
    }

    lateinit var getAllWishes:Flow<List<Wish>>

    init{
        viewModelScope.launch{
            getAllWishes = wishRepository.getAllWishes()
        }

    }



    fun addWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO){
            wishRepository.addAWish((wish))
        }
    }

    fun updateWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO){
            wishRepository.updateAWish(wish)
        }
    }

    fun deleteWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO){
            wishRepository.deleteAWish(wish)
        }
    }

    fun getWishById(id: Long): Flow<Wish> {
        return wishRepository.getAWishById(id)
    }


}