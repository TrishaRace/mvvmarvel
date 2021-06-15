package com.example.characters.domain.usecases

import com.example.characters.domain.repository.CharactersRepository
import com.example.characters.models.view.CharacterView
import com.example.utilities.either.Either
import com.example.utilities.usecase.FlowUseCase


class GetCharactersUseCase(private val repository: CharactersRepository) :
        FlowUseCase<GetCharactersUseCase.Input,Either<List<CharacterView>, String>>() {

        override fun prepareFlow(input: Input?) = repository.getCharacters(input?.offset, input?.fromPagination?:false)

        data class Input(val offset: Int?, val fromPagination: Boolean)

    }
