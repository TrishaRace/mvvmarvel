package com.example.characters.models.data

import com.example.characters.models.entity.CharactersEntity
import com.example.characters.models.view.CharactersView

data class Characters(
    val offset: Int?,
    val limit: Int?,
    val total: Int?,
    val count: Int?,
    val results: MutableList<Character>?,
) {

    fun toCharactersEntity() =
        CharactersEntity(
            null,
            offset,
            limit,
            total,
            count,
            mutableListOf()
        )

    fun toCharactersView() =
        CharactersView(
            offset?:0,
            limit?:0,
            total?:0,
            count?:0,
            results?.map { it.toCharacterView() }?.toMutableList()?: mutableListOf()
        )
}
