package com.example.characters.models.entity

import com.example.characters.models.data.Characters

data class CharactersEntity(
    val id: Int?,
    var offset: Int?,
    val limit: Int?,
    val total: Int?,
    val count: Int?,
    var results: MutableList<CharacterEntity>?
) {

    fun toCharacters() =
        Characters(
            offset,
            limit, total, count, results?.map { it.toCharacter() }?.toMutableList()
        )
}
