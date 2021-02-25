package com.pedronveloso.furiendsinneed.data

data class Dog(
    val name: String,
    val ageMonths: Int,
    val bio: String,
    val breed: Breed,
    var favored: Boolean = false
)

enum class Breed(val breedName: String) {
    MIXED("Mixed"),
    GERMAN_SHEPARD("German Shepard"),
    LABRADOR("Labrador"),
}