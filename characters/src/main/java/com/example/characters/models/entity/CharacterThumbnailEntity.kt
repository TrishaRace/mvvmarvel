package com.example.characters.models.entity

import com.davidups.marvel.data.models.data.CharacterThumbnail

data class CharacterThumbnailEntity(val path: String?, val extension: String?, val image: String?) {

    fun toCharacterThumbnail() = CharacterThumbnail(path, extension, image)
}
