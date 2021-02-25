package com.pedronveloso.furiendsinneed

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.pedronveloso.furiendsinneed.ui.NavigationViewModel
import com.pedronveloso.furiendsinneed.ui.ScreenName
import com.pedronveloso.furiendsinneed.ui.screens.DetailsScreenStart
import com.pedronveloso.furiendsinneed.ui.screens.HomeScreenStart
import com.pedronveloso.furiendsinneed.ui.theme.FURiendsInNeedTheme

class MainActivity : AppCompatActivity() {

    private val navigationViewModel by viewModels<NavigationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FURiendsInNeedTheme {
                FURiendsInNeedApp(navigationViewModel)
            }
        }
    }

    override fun onBackPressed() {
        if (navigationViewModel.onBack().not()) {
            super.onBackPressed()
        }
    }
}

@Composable
fun FURiendsInNeedApp(navigationVM: NavigationViewModel) {
    val currentScreen = navigationVM.currentScreen.observeAsState()
    when (currentScreen.value) {
        ScreenName.HOME -> HomeScreenStart()
        ScreenName.DETAILS -> DetailsScreenStart()
    }
}



