package com.example.characters.models.view

import com.example.characters.models.data.Characters

data class CharactersView(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: MutableList<CharacterView>
) {

    fun toCharacters() =
        Characters(offset, limit, total, count, results.map { it.toCharacter() }.toMutableList())
}
