package com.omeriyioz.marvel.features.characterlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CharacterListScreen(
    characterListViewModel: CharacterListViewModel = viewModel(),
    onClick: () -> Unit,
) {
    val characterListDTO by characterListViewModel.characterListDTO.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = {
                onClick()
            })
    ) {

        Text("Name : ${characterListDTO?.status}")
        Divider(color = Color.Red)

        /*userResponseDTO?.items?.let { userList ->
            LazyColumn(
                content = {
                    items(userList) { user ->
                        Text(
                            "avatar_url : ${user.avatar_url} - " +
                                "id : ${user.id} - " +
                                "login : ${user.login} - "
                        )

                        Divider(color = Color.Black)
                        Spacer(modifier = Modifier.height(8.dp))

                    }
                }
            )
        }*/

    }
}