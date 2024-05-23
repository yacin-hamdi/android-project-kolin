package eu.tutorials.mywishlistapp.data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)


object DummyWish{
    val wishList = listOf(
        Wish(title = "wish1", description = "description1"),
        Wish(title = "wish2", description = "description2"),
        Wish(title = "wish3", description = "description3")
    )
}