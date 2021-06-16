package com.example.mvvmarvel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.characters.feature.characterDetail.CharacterDetailFragment
import com.example.characters.feature.characterList.CharactersFragment
import com.example.characters.models.view.CharacterView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadCharacterList()
    }

    fun loadCharacterList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.activity_container, CharactersFragment())
            .addToBackStack("charactersList").commit()
    }

    fun loadCharacterDetail(character: CharacterView) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.activity_container, CharacterDetailFragment.newInstance(character))
            .addToBackStack("charactersInfo").commit()
    }
}