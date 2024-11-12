package com.example.Bobs.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Bobs.domain.GetCharactersUseCase
import com.example.Bobs.models.Characters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor( private val getCharactersUseCase: GetCharactersUseCase) : ViewModel() {

    private  val _UIdata = MutableStateFlow<List<Characters>>(emptyList())
    val UIData : StateFlow<List<Characters>> = _UIdata.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading:StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        loadCharacterData()
    }

    private fun loadCharacterData(){

        viewModelScope.launch {
            _isLoading.value = true
            try {
                _UIdata.value = getCharactersUseCase()
            } catch (_:Exception)
            {

            }
            finally {
                _isLoading.value = false
            }
        }
    }
}