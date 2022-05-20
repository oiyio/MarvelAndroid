package com.omeriyioz.data.network

import com.omeriyioz.data.network.models.CharacterListDTO

class MarvelRemoteDataSource @javax.inject.Inject constructor(
    private val retrofitService: MarvelApiService
) {

    suspend fun getRepoDTOList(user: String): CharacterListDTO {
        return retrofitService.getCharacter("1011334")
    }

    suspend fun getCharacterList(): CharacterListDTO {
        return retrofitService.getCharacterList()
    }
}