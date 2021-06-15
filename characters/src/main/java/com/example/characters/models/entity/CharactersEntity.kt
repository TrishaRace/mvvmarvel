package com.example.characters.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.characters.models.data.Characters

@Entity
data class CharactersEntity(
    @PrimaryKey(autoGenerate = true)
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
