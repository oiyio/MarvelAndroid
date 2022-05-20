package com.omeriyioz.marvel.features.character

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CharacterDetailScreen(
    id: String?,
    characterDetailViewModel: CharacterDetailViewModel = viewModel()
) {
    val characterListDTO by characterDetailViewModel.characterListDTO.observeAsState()
    characterDetailViewModel.getCharacter(id)

    Column(modifier = Modifier.fillMaxSize()) {

        Text("copyright : ${characterListDTO?.copyright}")
        Divider(color = Color.Red)


        characterListDTO?.data?.results?.let { results ->
            LazyColumn(
                content = {
                    items(results) { result ->
                        Text(
                            text = "avatar_url : ${result.name} - " +
                                "id : ${result.id}"
                        )

                        Divider(color = Color.Black)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            )
        }

    }
}
