package com.pedronveloso.furiendsinneed.data

import com.pedronveloso.furiendsinneed.R

object PupsProvider {

    val pupsList: List<Dog> by lazy { sPAWnPups() }

    private fun sPAWnPups(): List<Dog> {
        val shelter = arrayListOf<Dog>()

        for (i in PUP_NAMES.indices) {
            shelter.add(Dog(PUP_NAMES[i], PUP_AGES[i], LOREM_IPSUM, PUP_BREEDS[i], PUP_PHOTOS[i]))
        }

        return shelter
    }


    private val PUP_NAMES = listOf("Hulk", "Mila", "Max", "Taco", "Dior")
    private val PUP_BREEDS =
        listOf(Breed.MIXED, Breed.GERMAN_SHEPARD, Breed.LABRADOR, Breed.POMERANIAN, Breed.GREYHOUND)
    private val PUP_AGES = listOf(4, 3, 12, 4, 6)
    private val PUP_PHOTOS =
        listOf(R.drawable.pup1, R.drawable.pup2, R.drawable.pup3, R.drawable.pup4, R.drawable.pup5)
}


const val LOREM_IPSUM =
    """Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco 
laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in 
voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat 
cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."""