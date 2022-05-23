package com.omeriyioz.data.network

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.omeriyioz.data.network.models.CharacterListDTO
import com.omeriyioz.data.network.models.Result
import kotlinx.coroutines.delay

class MarvelPagingDataSource @javax.inject.Inject constructor(
    private val retrofitService: MarvelApiService
) : PagingSource<Int, Result>() {

    private suspend fun getCharacterList(offset : Int): CharacterListDTO {
        return retrofitService.getCharacterList(offset)
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val offset = (params.key ?: START_INDEX)
            val limit = LOAD_SIZE
            val response = getCharacterList(offset = offset)
            Log.d("omertest", "$offset $limit $response")
            val nextKey = offset + LOAD_SIZE


            delay(500)


            LoadResult.Page(response.data?.results.orEmpty(), null, nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}