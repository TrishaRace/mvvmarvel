package com.example.characters.domain.repository

import com.example.characters.models.view.CharacterView
import com.example.characters.models.view.CharactersView
import com.example.utilities.State
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    fun getCharacters(): Flow<State<CharactersView>>
    fun getCharacterDetail(id: String): Flow<State<CharacterView>>

}