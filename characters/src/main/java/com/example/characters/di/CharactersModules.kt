package com.example.characters.di

import com.example.characters.data.datasource.CharactersDataSource
import com.example.characters.data.datasource.CharactersDataSourceImp
import com.example.characters.data.repository.CharactersRepositoryImp
import com.example.characters.data.service.CharacterService
import com.example.characters.domain.repository.CharactersRepository
import com.example.characters.domain.usecases.GetCharacterDetailUseCase
import com.example.characters.domain.usecases.GetCharactersUseCase
import org.koin.dsl.module


val characterRepositoryModule = module {
    factory<CharactersRepository> { CharactersRepositoryImp(get()) }
}
val characterDataSourceModule = module {
    factory<CharactersDataSource> { CharactersDataSourceImp(get(),get()) }
}
val characterServiceModule = module {
    factory { CharacterService(get()) }
}

val characterUseCaseModule = module {
    factory { GetCharactersUseCase(get()) }
}

val characterDetailUseCaseModule = module {
    factory { GetCharacterDetailUseCase(get()) }
}

