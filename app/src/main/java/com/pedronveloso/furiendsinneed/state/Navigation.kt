package com.pedronveloso.furiendsinneed.ui

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

enum class ScreenName { HOME, DETAILS }

class NavigationViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _currentScreen = MutableLiveData(ScreenName.HOME)
    val currentScreen: LiveData<ScreenName> = _currentScreen

    /**
     * Go back (always to [ScreenName.HOME]).
     *
     * Returns true if this call caused user-visible navigation. Will always return false
     * when [currentScreen] is [ScreenName.HOME].
     */
    @MainThread
    fun onBack(): Boolean {
        val wasHandled = currentScreen.value != ScreenName.HOME
        _currentScreen.postValue(ScreenName.HOME)
        return wasHandled
    }

    /**
     * Navigate to requested [ScreenName].
     */
    @MainThread
    fun navigateTo(screen: ScreenName) {
        _currentScreen.postValue(screen)
    }
}
