package com.example.mvvmarvel.core.di

import com.example.mvvmarvel.feature.character.characterList.CharactersViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val charactersViewModelModule = module {
    viewModel { CharactersViewModel(get()) }
}