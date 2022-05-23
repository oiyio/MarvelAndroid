package com.omeriyioz.marvel.features.characterlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharacterListScreen(
    characterListViewModel: CharacterListViewModel = hiltViewModel(),
    onClick: (String?) -> Unit,
) {

    val result = characterListViewModel.getAllImages.collectAsLazyPagingItems()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Text("Characters List")
        Divider(color = Color.Red)

        LazyColumn(
            content = {
                items(result) { result ->
                    result?.let {
                        Text(
                            text = "${result.name}",
                            modifier = Modifier.clickable(
                                onClick = {
                                    onClick(result.id)
                                }
                            )
                        )

                        result.thumbnail?.path?.let { thumbnailPath ->
                            val httpsPath = if (thumbnailPath.startsWith("https")) thumbnailPath
                            else thumbnailPath.replaceFirst("http", "https")

                            val imageUrl = "$httpsPath.${result.thumbnail!!.extension}"

                            GlideImage(
                                imageModel = imageUrl,
                                placeHolder = painterResource(id = android.R.drawable.stat_notify_error),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(RoundedCornerShape(20))
                                    .clickable(
                                        onClick = {
                                            onClick(result.id)
                                        }
                                    ),
                                error = ImageBitmap.imageResource(android.R.drawable.stat_notify_error)
                            )
                        }

                        Divider(color = Color.Black)
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                }
            }
        )

    }
}