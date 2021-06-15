package com.example.mvvmarvel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.characters.feature.characterDetail.CharacterDetailFragment
import com.example.characters.feature.characterList.CharactersFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadCharacterList()

    }

    //probar privados

    fun loadCharacterList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.activity_container, CharactersFragment())
            .addToBackStack("charactersList").commit()
    }

   /* fun loadCharacterDetail(character: Character) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.activity_container, CharacterDetailFragment.newInstance(character))
            .addToBackStack("charactersInfo").commit()
    }*/
}