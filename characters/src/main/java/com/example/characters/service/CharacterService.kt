package com.example.characters.service

import com.example.characters.models.data.Character
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

class CharacterService(retrofit: Retrofit) {
    interface MarvelService {
        @GET("characters?ts=1&apikey=bb002cae0025452e0e19ba71896a9b11&hash=75772836ecf8d7ad6adabe834692d8fb")
        fun getCharacters(): Call<List<Character>>
    }
}