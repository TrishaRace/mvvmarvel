package com.example.mvvmarvel.feature.character.characterDetail

import com.example.characters.domain.usecases.GetCharactersUseCase
import androidx.lifecycle.ViewModel

class CharacterDetailViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    /*private var _characters = MutableLiveData<List<CharacterView>>()
    val characters get() = _characters

    fun getCharacters(fromPagination: Boolean = false) {
        viewModelScope.launch {
            getCharactersUseCase.prepare(
                GetCharactersUseCase.Input(
                    calculateOffset(),
                    fromPagination
                )
            )
                .onStart { showLoading(true) }
                .onCompletion { showLoading(false) }
                .catch { showError("Error inesperado") }
                .collect { result ->
                    result
                    when (result) {
                        is Either.Success -> {
                            _characters.value = result.data
                        }
                        is Either.Failure -> showError(result.error)
                    }
                }
        }
    }

    private fun calculateOffset() = _characters.value?.offset?.let { it + 10 }.orEmpty(*/
}
