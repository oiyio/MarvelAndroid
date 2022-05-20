package com.omeriyioz.marvel.features.characterlist

import androidx.compose.foundation.clickable
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
fun CharacterListScreen(
    characterListViewModel: CharacterListViewModel = viewModel(),
    onClick: (String?) -> Unit,
) {
    val characterListDTO by characterListViewModel.characterListDTO.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Text("Name : ${characterListDTO?.data?.results?.size}")
        Divider(color = Color.Red)

        characterListDTO?.data?.results?.let { results ->
            LazyColumn(
                content = {
                    items(results) { result ->
                        Text(
                            text = "avatar_url : ${result.name} - " +
                                "id : ${result.id}",
                            modifier = Modifier.clickable(
                                onClick = {
                                    onClick(result.id)
                                }
                            )
                        )

                        Divider(color = Color.Black)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            )
        }

    }
}