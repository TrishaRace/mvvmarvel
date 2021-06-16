package com.example.mvvmarvel.feature.character.characterList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.characters.domain.usecases.GetCharactersUseCase
import com.example.characters.models.view.CharacterView
import com.example.characters.models.view.CharactersView
import com.example.exception.Failure
import com.example.platform.BaseViewModel
import com.example.utilities.Error
import com.example.utilities.Success
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
) : BaseViewModel() {

    private var getForecastsJob: Job? = null

    private var _characters = MutableLiveData<List<CharacterView>>()
    val characters get() = _characters

    private val offset = 0
    fun getCharacters(fromPagination: Boolean = false) {
        getForecastsJob.cancelIfActive()
        getForecastsJob = viewModelScope.launch {
            getCharactersUseCase()
                .onStart { handleShowSpinner(true) }
                .onCompletion { handleShowSpinner(false) }
                .catch { handleFailure(Failure.Throwable(it)) }
                .collect { result ->
                    when (result) {
                        is Success<CharactersView> -> {
                            _characters.value = result.data.results
                        }
                        is Error -> {
                            handleFailure(result.failure)
                        }
                    }
                }
        }
    }

    fun Job?.cancelIfActive() {
        if (this?.isActive == true) {
            cancel()
        }
    } //meter extension en el core
}