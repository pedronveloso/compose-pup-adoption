package com.pedronveloso.furiendsinneed.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pedronveloso.furiendsinneed.R
import com.pedronveloso.furiendsinneed.data.Breed
import com.pedronveloso.furiendsinneed.data.Dog
import com.pedronveloso.furiendsinneed.state.DogsViewModel
import com.pedronveloso.furiendsinneed.ui.theme.FURiendsInNeedTheme
import com.pedronveloso.furiendsinneed.ui.theme.Typography

@Composable
fun HomeScreenStart(dogsViewModel: DogsViewModel = viewModel()) {
    val dogs = dogsViewModel.dogs.observeAsState()
    LazyColumn {
        items(dogs.value!!) { dog ->
            DrawPupCard(dog)
        }
    }
}

@Composable
fun DrawPupCard(dog: Dog) {
    Card(Modifier.padding(8.dp)) {
        Column(Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(dog.photo),
                contentDescription = dog.bio,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(4.dp))
            Text(dog.name, style = Typography.h4)
            Spacer(Modifier.height(4.dp))
            Row(Modifier.fillMaxWidth()) {
                Text(stringResource(id = R.string.dog_age, dog.ageMonths), style = Typography.body2)
                Spacer(Modifier.width(8.dp))
                Text("·", style = Typography.body1)
                Spacer(Modifier.width(8.dp))
                Text(dog.breed.breedName, style = Typography.body2)
            }

        }
    }
}

@Preview
@Composable
fun PupCardPreview() {
    FURiendsInNeedTheme {
        DrawPupCard(dog = Dog("Fox", 3, "bio goes here", Breed.MIXED, R.drawable.pup1))
    }
}