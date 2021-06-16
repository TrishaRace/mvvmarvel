package com.example.characters.data.repository

import com.example.characters.data.datasource.CharactersDataSource
import com.example.characters.domain.repository.CharactersRepository

class CharactersRepositoryImp(
    private val charactersDataSource: CharactersDataSource
) : CharactersRepository {
    override fun getCharacters() = charactersDataSource.getCharacters()

}