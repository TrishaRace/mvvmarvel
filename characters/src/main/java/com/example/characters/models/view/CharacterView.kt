package com.example.characters.models.view

import android.os.Parcelable
import com.example.characters.models.data.Character
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterView(
    val id: Int,
    val name: String,
    val description: String,
    val imageURI: String,
) : Parcelable {

    fun toCharacter() =
        Character(id, name, description, imageURI)
}