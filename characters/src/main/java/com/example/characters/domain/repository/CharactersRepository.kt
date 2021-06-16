package com.example.characters.domain.repository

import com.example.characters.models.view.CharacterView
import com.example.characters.models.view.CharactersView
import com.example.utilities.State
import com.example.utilities.either.Either
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    fun getCharacters(): Flow<State<CharactersView>>
}