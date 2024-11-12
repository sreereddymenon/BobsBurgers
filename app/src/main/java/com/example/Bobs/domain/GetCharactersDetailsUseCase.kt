package com.example.Bobs.domain

import com.example.Bobs.data.CharactersRepository
import com.example.Bobs.models.Characters
import javax.inject.Inject

class GetCharactersDetailsUseCase @Inject constructor(private val repository: CharactersRepository) {
    suspend operator fun invoke(id: Int) : Characters = repository.getCharacterData(id)

}