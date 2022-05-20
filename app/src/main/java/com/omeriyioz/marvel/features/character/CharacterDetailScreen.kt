package com.omeriyioz.marvel.features.character

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
fun CharacterDetailScreen(
    characterDetailViewModel: CharacterDetailViewModel = viewModel()
) {
    val repoDTOListState by characterDetailViewModel.repoDTOList.observeAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        Text("copyright : ${repoDTOListState?.copyright}")
        Divider(color = Color.Red)

        /* LazyColumn(
             content = {
                 items(repoDTOListState) { repoDTO ->
                     Text(
                         "Name : ${repoDTO.name} - " +
                             "RepoId : ${repoDTO.repoId} - " +
                             "Stars : ${repoDTO.stars} - " +
                             "IssueCount : ${repoDTO.issueCount} - " +
                             "owner.login : ${repoDTO.owner?.login} - " +
                             "owner.avatarUrl : ${repoDTO.owner?.avatarUrl} - " +
                             "owner.ownerId : ${repoDTO.owner?.ownerId} - "
                     )

                     Divider(color = Color.Black)
                     Spacer(modifier = Modifier.height(8.dp))

                 }
             }
         )*/

    }
}
