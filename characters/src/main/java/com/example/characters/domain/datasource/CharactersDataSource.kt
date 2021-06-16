package com.example.characters.domain.datasource

import com.example.characters.models.view.CharacterView
import com.example.characters.models.data.Character
import com.example.characters.models.view.CharactersView
import com.example.utilities.State
import com.example.utilities.either.Either
import kotlinx.coroutines.flow.Flow

interface CharactersDataSource {
    fun getCharacters(offset: Int?, fromPagination: Boolean): Flow<State<CharactersView>>
}