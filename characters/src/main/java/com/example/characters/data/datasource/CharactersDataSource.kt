package com.example.characters.data.datasource

import com.example.characters.models.view.CharacterView
import com.example.characters.models.view.CharactersView
import com.example.utilities.State
import kotlinx.coroutines.flow.Flow

interface CharactersDataSource {
    fun getCharacters(): Flow<State<CharactersView>>
    fun getCharacterDetail(id: String): Flow<State<CharacterView>>

}