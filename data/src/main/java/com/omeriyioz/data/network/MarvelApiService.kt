package com.omeriyioz.data.network

import com.omeriyioz.data.network.models.CharacterListDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApiService {

    /*
   * 🔥 Character List
   * */
    @GET("v1/public/characters")
    suspend fun getCharacterList(@Query("offset") offset: Int): CharacterListDTO

    /*
    * 🔥 Character Detail
    * */
    @GET("v1/public/characters/{characterId}")
    suspend fun getCharacter(@Path("characterId") characterId: String): CharacterListDTO
}
