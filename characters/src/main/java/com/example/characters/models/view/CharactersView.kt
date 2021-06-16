package com.example.characters.models.view

import com.example.characters.models.data.Characters

data class CharactersView(
    val results: MutableList<CharacterView>
) {

    fun toCharacters() =
        Characters(results.map { it.toCharacter() }.toMutableList())
}
