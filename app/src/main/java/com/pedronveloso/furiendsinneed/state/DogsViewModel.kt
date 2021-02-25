package com.pedronveloso.furiendsinneed.state

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.pedronveloso.furiendsinneed.data.Dog
import com.pedronveloso.furiendsinneed.data.PupsProvider

class DogsViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _dogs = MutableLiveData(PupsProvider.pupsList)
    val dogs: LiveData<List<Dog>> = _dogs

    fun favoriteDog(dog: Dog) {
        val newDogList = _dogs.value!!
        newDogList.firstOrNull { it.name == dog.name }?.favored = true
        _dogs.postValue(newDogList)
    }
}