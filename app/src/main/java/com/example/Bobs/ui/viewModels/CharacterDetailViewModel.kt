package com.example.Bobs.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Bobs.domain.GetCharactersDetailsUseCase
import com.example.Bobs.models.Characters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(private val repository: GetCharactersDetailsUseCase) : ViewModel() {

    private val _character = MutableStateFlow<Characters?>(null)
    val character: StateFlow<Characters?> = _character.asStateFlow()

    fun loadCharacter(id: Int) {
        viewModelScope.launch {
            try {
                _character.value = repository.invoke(id)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}