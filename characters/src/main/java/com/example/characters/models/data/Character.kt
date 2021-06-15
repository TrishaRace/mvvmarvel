package com.example.characters.models.data

import com.davidups.marvel.data.models.data.CharacterThumbnail
import com.example.characters.models.entity.CharacterEntity
import com.example.characters.models.view.CharacterView

data class Character(
    val id: Int,
    val name: String?,
    val description: String?,
    val modified: String?,
    val resourceURI: String?,
    val characterImage: CharacterThumbnail?
) {

    fun toCharacterEntity() = CharacterEntity(id, name, description, modified, resourceURI, characterImage?.toCharacterThumbnailEntity())
    fun toCharacterView() = CharacterView(
        id,
        name.orEmpty(),
        description.orEmpty(),
        modified,
        resourceURI.orEmpty(),
        characterImage?.image().orEmpty()
    )
}
