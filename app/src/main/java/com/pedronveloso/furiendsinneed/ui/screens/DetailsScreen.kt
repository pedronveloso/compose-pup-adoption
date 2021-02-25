package com.pedronveloso.furiendsinneed.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pedronveloso.furiendsinneed.R
import com.pedronveloso.furiendsinneed.ui.NavigationViewModel
import com.pedronveloso.furiendsinneed.ui.theme.Typography

@Composable
fun DetailsScreenStart(navigationViewModel: NavigationViewModel = viewModel()) {
    val dog = navigationViewModel.currentDog.value!!
    val (showDialog, setShowDialog) = remember { mutableStateOf(false) }
    Column(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(dog.photo),
            contentDescription = dog.bio,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = dog.name, style = Typography.h2)
            Spacer(Modifier.height(8.dp))
            DogAgeAndBreedRow(dog)
            Spacer(Modifier.height(8.dp))
            Text(text = dog.bio, style = Typography.caption)
            Spacer(Modifier.height(16.dp))
            Button(onClick = { setShowDialog(true) }) {
                Text(stringResource(R.string.adopt))
            }

            // Show dialog.
            EndOfDemoDialog(showDialog, setShowDialog)
        }
    }

}


@Composable
fun EndOfDemoDialog(showDialog: Boolean, setShowDialog: (Boolean) -> Unit) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { },
            text = {
                Text(
                    text = "End of demo! I hope you've enjoyed it!\nThis app was made pawsible by Jetpack Compose :)",
                    style = MaterialTheme.typography.body2
                )
            },
            confirmButton = {
                TextButton(onClick = { setShowDialog(false) }) {
                    Text(text = "🐾", style = MaterialTheme.typography.body1)
                }
            }
        )

    }
}