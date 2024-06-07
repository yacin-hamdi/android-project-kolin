package eu.tutorials.musicappui

import androidx.annotation.DrawableRes

data class Lib(@DrawableRes val icon: Int, val name: String)

val libraries = listOf<Lib>(
    Lib(R.drawable.ic_subscribe, "Playlist"),
    Lib(R.drawable.ic_account, "Artist"),
    Lib(R.drawable.baseline_apps_24, "Album"),
    Lib(R.drawable.baseline_music_video_24, "Songs"),
    Lib(R.drawable.baseline_person_add_alt_1_24, "Genre")
)