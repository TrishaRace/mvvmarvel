package com.example.characters.domain.usecases

import com.example.characters.domain.repository.CharactersRepository
import com.example.characters.models.view.CharacterView
import com.example.characters.models.view.CharactersView
import com.example.utilities.State
import com.example.utilities.usecase.FlowUseCase
import kotlinx.coroutines.flow.Flow

class GetCharacterDetailUseCase(private val repository: CharactersRepository) :
    FlowUseCase<State<CharacterView>, GetCharacterDetailUseCase.Input>() {

    override fun run(params: Input?) = repository.getCharacterDetail(params?.id?:"0")

    data class Input(val id: String)
}
