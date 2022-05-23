package com.omeriyioz.data.network

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.omeriyioz.data.network.models.CharacterListDTO
import com.omeriyioz.data.network.models.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

const val LOAD_SIZE = 30
const val START_INDEX = 0

class MarvelRepository @Inject constructor(
    private val retrofitService: MarvelApiService
) {

    suspend fun getCharacter(id: String): CharacterListDTO {
        return retrofitService.getCharacter(id)
    }

    // https://gateway.marvel.com:443/v1/public/characters/1011334/comics?startYear=2005&orderBy=onsaleDate&limit=10&apikey=beb0043f8fde72f12cc9c076475e7c1c
    suspend fun getComics(id: String): CharacterListDTO {
        return retrofitService.getComics(
            characterId = id,
            startYear = "2005",
            orderBy = "onsaleDate",
            limit = "10"
        )
    }

    fun getCharacterListPaginated(): Flow<PagingData<Result>> = Pager(
        PagingConfig(
            pageSize = LOAD_SIZE,
            enablePlaceholders = false,
            initialLoadSize = LOAD_SIZE
        )
    ) {
        MarvelPagingDataSource(retrofitService)
    }.flow
}