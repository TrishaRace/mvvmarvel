package com.example.characters.di

import com.example.characters.domain.datasource.CharactersDataSource
import com.example.characters.domain.datasource.CharactersDataSourceImp
import com.example.characters.domain.repository.CharactersRepository
import com.example.characters.domain.repository.CharactersRepositoryImp
import com.example.characters.service.CharacterService
import org.koin.dsl.module

class CharactersModules {

    val characterRepositoryModule = module {
        factory<CharactersRepository> { CharactersRepositoryImp(get()) }
    }
    val characterDataSourceModule = module {
        factory<CharactersDataSource> { CharactersDataSourceImp(get()) }
    }
    val characterServiceModule = module {
        factory { CharacterService(get()) }
    }
}