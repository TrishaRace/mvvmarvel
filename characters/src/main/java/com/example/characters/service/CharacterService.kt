package com.example.characters.service

import com.example.characters.models.data.Character
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

class CharacterService(retrofit: Retrofit) : CharacterApi {

    private val characterApi by lazy { retrofit.create(CharacterApi::class.java) }

    override suspend fun getCharacters(limit: Int?, offset: Int?) =
        characterApi.getCharacters(limit, offset)

    override suspend fun getCharacter(id: String?) = characterApi.getCharacter(id)
}
