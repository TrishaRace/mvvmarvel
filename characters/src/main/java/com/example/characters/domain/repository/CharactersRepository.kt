package com.example.characters.domain.repository

import com.example.characters.models.view.CharacterView
import com.example.utilities.either.Either
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    fun getCharacters(offset: Int?, pagination: Boolean): Flow<Either<List<CharacterView>,String>>
}