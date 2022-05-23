package com.omeriyioz.marvel.features.character

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharacterDetailScreen(
    id: String?,
    characterDetailViewModel: CharacterDetailViewModel = viewModel()
) {
    val characterListDTO by characterDetailViewModel.characterListDTO.observeAsState()
    characterDetailViewModel.getCharacter(id)

    Column(modifier = Modifier.fillMaxSize()) {

        characterListDTO?.data?.results?.let { results ->
            LazyColumn(
                content = {
                    items(results) { result ->
                        Text(
                            text = "${result.name}",
                            color = Color.Red,
                            fontWeight = FontWeight.Bold
                        )

                        result.thumbnail?.path?.let { thumbnailPath->
                            val httpsPath = if (thumbnailPath.startsWith("https")) thumbnailPath
                            else thumbnailPath.replaceFirst("http", "https")

                            val imageUrl = "$httpsPath.${result.thumbnail!!.extension}"

                            GlideImage(
                                imageModel = imageUrl,
                                placeHolder = painterResource(id = android.R.drawable.stat_notify_error),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                                    .clip(CircleShape),
                                error = ImageBitmap.imageResource(android.R.drawable.stat_notify_error)
                            )
                        }

                        Divider(color = Color.Black)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            )
        }

    }
}
