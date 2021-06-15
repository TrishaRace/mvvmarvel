package com.example.characters.domain.repository

import com.example.characters.domain.datasource.CharactersDataSource

class CharactersRepositoryImp(
    private val charactersDataSource: CharactersDataSource
) : CharactersRepository {
    override fun getCharacters(offset: Int?, fromPagination: Boolean) = charactersDataSource.getCharacters(offset, fromPagination)

}