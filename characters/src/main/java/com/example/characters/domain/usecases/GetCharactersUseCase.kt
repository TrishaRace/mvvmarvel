package com.example.characters.domain.usecases

import com.example.characters.domain.repository.CharactersRepository
import com.example.characters.models.view.CharactersView
import com.example.utilities.State
import com.example.utilities.usecase.FlowUseCase
import kotlinx.coroutines.flow.Flow


class GetCharactersUseCase(private val repository: CharactersRepository) :
    FlowUseCase<State<CharactersView>,GetCharactersUseCase.Input>() {


    data class Input(val offset: Int?, val fromPagination: Boolean)

    override fun run(params: Input?) = repository.getCharacters(params?.offset, false)




}
