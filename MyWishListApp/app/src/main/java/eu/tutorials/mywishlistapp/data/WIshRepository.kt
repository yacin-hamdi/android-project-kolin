package eu.tutorials.mywishlistapp.data

import kotlinx.coroutines.flow.Flow


class WIshRepository(private val wishDao: WishDao) {
    suspend fun addAWish(wish:Wish){
        wishDao.addAWish(wish)
    }

    suspend fun updateAWish(wish:Wish){
        wishDao.updateAWish(wish)
    }

    suspend fun deleteAWish(wish:Wish){
        wishDao.deleteAWish(wish)
    }

    fun getAllWishes(): Flow<List<Wish>>{
        return wishDao.getAllWishes()
    }

    fun getAWishById(id: Long): Flow<Wish> {
        return wishDao.getAWishById(id)
    }
}