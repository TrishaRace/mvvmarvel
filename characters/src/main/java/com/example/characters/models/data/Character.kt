package com.example.characters.models.data

import com.example.characters.models.entity.CharacterEntity
import com.example.characters.models.view.CharacterView

data class Character(
    val id: Int?,
    val name: String?,
    val description: String?,
    val imageURI: String?,
) {

    fun toCharacterEntity() = CharacterEntity(id, name, description, imageURI)
    fun toCharacterView() = CharacterView(
        id?:0,
        name.orEmpty(),
        description.orEmpty(),
        imageURI.orEmpty()
    )
}