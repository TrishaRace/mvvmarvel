package com.example.characters.models.entity

import com.example.characters.models.data.Character


data class CharacterEntity(
        val id: Int?,
        val name: String?,
        val description: String?,
        val imageURI: String?,
    ) {
        fun toCharacter() = Character(id, name, description, imageURI)
}