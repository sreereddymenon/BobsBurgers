package com.example.Bobs.data

import com.example.Bobs.models.Characters
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val apiService: NetworkAPIService) {

    suspend fun getAllData() : List<Characters> {
        val response = apiService.getAllCharacters()
        return response
    }

    suspend fun getCharacterData(id: Int): Characters =  apiService.getCharacterData(id)

}