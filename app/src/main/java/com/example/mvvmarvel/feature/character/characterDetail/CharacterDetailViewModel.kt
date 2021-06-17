package com.example.mvvmarvel.feature.character.characterDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.characters.domain.usecases.GetCharacterDetailUseCase
import com.example.characters.models.view.CharacterView
import com.example.exception.Failure
import com.example.extensions.cancelIfActive
import com.example.platform.BaseViewModel
import com.example.utilities.Error
import com.example.utilities.Success
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CharacterDetailViewModel(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase
) : BaseViewModel() {

    private var getForecastsJob: Job? = null

    private var _characterDetail = MutableLiveData<CharacterView>()
    val characterDetail get() = _characterDetail

    fun getCharacterDetail(characterId: Int) {
        getForecastsJob.cancelIfActive()
        getForecastsJob = viewModelScope.launch {
            getCharacterDetailUseCase(GetCharacterDetailUseCase.Input(characterId.toString()))
                .onStart { handleShowSpinner(true) }
                .onCompletion { handleShowSpinner(false) }
                .catch { handleFailure(Failure.Throwable(it)) }
                .collect { result ->
                    when (result) {
                        is Success<CharacterView> -> {
                            _characterDetail.value = result.data
                        }
                        is Error -> {
                            handleFailure(result.failure)
                        }
                    }
                }
        }
    }
}
