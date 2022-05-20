package com.omeriyioz.data.network

import com.omeriyioz.data.network.models.CharacterListDTO
import javax.inject.Inject

class MarvelRepository @Inject constructor(
    private val marvelRemoteDataSource: MarvelRemoteDataSource
) {

    suspend fun getCharacter(id: String): CharacterListDTO {
        return marvelRemoteDataSource.getCharacter(id)
    }

    suspend fun getCharacterList(): CharacterListDTO {
        return marvelRemoteDataSource.getCharacterList()
    }
}
