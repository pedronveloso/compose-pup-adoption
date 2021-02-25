package com.pedronveloso.furiendsinneed.data

import androidx.annotation.DrawableRes

data class Dog(
    val name: String,
    val ageMonths: Int,
    val bio: String,
    val breed: Breed,
    @DrawableRes val photo: Int,
    var favored: Boolean = false
)

enum class Breed(val breedName: String) {
    MIXED("Mixed"),
    GERMAN_SHEPARD("German Shepard"),
    LABRADOR("Labrador"),
    POMERANIAN("Pomeranian"),
    GREYHOUND("Greyhound"),
}