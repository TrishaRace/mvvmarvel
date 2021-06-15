package com.example.characters.feature.characterDetail

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.characters.domain.usecases.GetCharactersUseCase
import kotlinx.coroutines.flow.onStart
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.characters.models.data.Character
import com.example.utilities.either.Either
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

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
