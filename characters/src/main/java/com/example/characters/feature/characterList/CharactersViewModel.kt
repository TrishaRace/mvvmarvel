package com.example.characters.feature.characterList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.characters.models.view.CharacterView
import com.example.characters.domain.usecases.GetCharactersUseCase
import com.example.utilities.either.Either
import com.example.utilities.either.onFailure
import com.example.utilities.either.onSuccess
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable.cancel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CharactersViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {


    private var _characters = MutableLiveData<List<CharacterView>>()
    val characters get() = _characters
    var _failure: MutableLiveData<String> = MutableLiveData()
    val failure get() = _failure

    var _showLoading: MutableLiveData<Boolean> = MutableLiveData()
    val showLoading get() = _showLoading

    fun showError(failure: String?) {
        this.failure.value = failure
    }

    fun showLoading(show: Boolean) {
        this.showLoading.value = show
    }

    private val offset = 0
    fun getCharacters(fromPagination: Boolean = false) {
        viewModelScope.launch {
            getCharactersUseCase(GetCharactersUseCase.Input(calculateOffset(), fromPagination))
                .onStart {
                    showLoading(true) }
                .onCompletion {
                    showLoading(false) }
                .catch { a->
                    showError(a.message) }
                .collect { result ->
                   result
                    result.onSuccess {
                        _characters.value = it.results }
                    result.onFailure {
                        showError("Error en la llamada") }
                }
        }
    }



    private fun calculateOffset() = offset + 10


}