package com.omeriyioz.data.network

import com.omeriyioz.data.network.models.CharacterListDTO

class MarvelRemoteDataSource @javax.inject.Inject constructor(
    private val retrofitService: MarvelApiService
) {

    suspend fun getCharacter(id: String): CharacterListDTO {
        return retrofitService.getCharacter(id)
    }

    suspend fun getCharacterList(): CharacterListDTO {
        return retrofitService.getCharacterList()
    }
}