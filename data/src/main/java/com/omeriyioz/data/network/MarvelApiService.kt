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

    /*
    * 🔥 Comics list of the character
    * https://gateway.marvel.com:443/v1/public/characters/1011334/comics?startYear=2005&orderBy=onsaleDate&limit=10&apikey=beb0043f8fde72f12cc9c076475e7c1c
    * */
    @GET("v1/public/characters/{characterId}/comics")
    suspend fun getComics(
        @Path("characterId") characterId: String,
        @Query("startYear") startYear: String,
        @Query("orderBy") orderBy: String,
        @Query("limit") limit: String
    ): CharacterListDTO
}
