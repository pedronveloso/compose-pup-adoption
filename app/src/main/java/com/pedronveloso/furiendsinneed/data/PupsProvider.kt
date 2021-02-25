package com.pedronveloso.furiendsinneed.data

object PupsProvider {

    val pupsList: List<Dog> by lazy { sPAWnPups() }

    private fun sPAWnPups(): List<Dog> {
        val shelter = arrayListOf<Dog>()

        for (i in PUP_NAMES.indices) {
            shelter.add(Dog(PUP_NAMES[i], PUP_AGES[i], LOREM_IPSUM, PUP_BREEDS[i]))
        }

        return shelter
    }


    private val PUP_NAMES = listOf("Hulk", "Mila", "Max", "Taco", "Dior")
    private val PUP_BREEDS = listOf(Breed.MIXED, Breed.MIXED, Breed.MIXED, Breed.MIXED, Breed.MIXED)
    private val PUP_AGES = listOf(4, 3, 12, 4, 6)
}


const val LOREM_IPSUM =
    """Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
        | labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco 
        | laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in 
        | voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat 
        | cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."""