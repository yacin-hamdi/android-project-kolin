package ym.tutorials.navigationsample

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    var name: String,
    var age: Int
):Parcelable