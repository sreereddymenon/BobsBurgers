package com.example.Bobs.data

import com.example.Bobs.models.Characters
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkAPIService {

    @GET("/characters?sortBy=name&OrderBy=asc")
    suspend fun getAllCharacters() : List<Characters>

    @GET("/characters/{id}")
    suspend fun getCharacterData(@Path(value = "id") id: Int) : Characters

}