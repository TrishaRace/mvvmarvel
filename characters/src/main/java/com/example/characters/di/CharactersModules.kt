package com.example.characters.di

import com.example.characters.domain.datasource.CharactersDataSource
import com.example.characters.domain.datasource.CharactersDataSourceImp
import com.example.characters.domain.repository.CharactersRepository
import com.example.characters.domain.repository.CharactersRepositoryImp
import com.example.characters.domain.usecases.GetCharactersUseCase
import com.example.characters.feature.characterList.CharactersViewModel
import com.example.characters.service.CharacterService
import org.koin.android.viewmodel.dsl.viewModel
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

val characterUseCasesModule = module {
    factory { GetCharactersUseCase(get()) }
}

val charactersViewModel = module {
    viewModel { CharactersViewModel(get()) }
}
