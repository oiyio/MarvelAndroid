package com.omeriyioz.data.network

import com.omeriyioz.data.network.models.CharacterListDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelApiService {

    /*
   * 🔥 Character List
   * */
    @GET("v1/public/characters")
    suspend fun getCharacterList(): CharacterListDTO

    /*
    * 🔥 Character Detail
    * */
    @GET("v1/public/characters/{characterId}")
    suspend fun getCharacter(@Path("characterId") characterId: String): CharacterListDTO
}
