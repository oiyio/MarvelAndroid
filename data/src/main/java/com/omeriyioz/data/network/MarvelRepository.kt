package com.omeriyioz.data.network

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.omeriyioz.data.network.models.CharacterListDTO
import com.omeriyioz.data.network.models.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

const val LOAD_SIZE = 10
const val START_INDEX = 0

class MarvelRepository @Inject constructor(
    private val retrofitService: MarvelApiService
) {

    suspend fun getCharacter(id: String): CharacterListDTO {
        return retrofitService.getCharacter(id)
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