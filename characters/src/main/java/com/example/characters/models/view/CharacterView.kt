package com.example.characters.models.view

import android.os.Parcelable
import com.davidups.marvel.data.models.data.CharacterThumbnail
import com.example.characters.models.data.Character
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterView(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String?,
    val resourceURI: String,
    val image: String
) : Parcelable {


    fun toCharacter() =
        Character(id, name, description, modified, resourceURI, CharacterThumbnail.thumbail(image))
}
