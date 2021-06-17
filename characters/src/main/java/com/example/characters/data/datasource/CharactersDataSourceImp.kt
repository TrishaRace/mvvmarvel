package com.example.characters.data.datasource

import com.example.characters.models.view.CharactersView
import com.example.characters.data.service.CharacterService
import com.example.characters.models.view.CharacterView
import com.example.exception.Failure
import com.example.platform.NetworkHandler
import com.example.utilities.State
import com.example.utilities.Success
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import com.example.utilities.Error

class CharactersDataSourceImp(
    private val networkHandler: NetworkHandler,
    private val service: CharacterService
) : CharactersDataSource {

    override fun getCharacters(
    ) = flow {
        emit(getCharactersFromService())
    }.catch {
        emit(Error(Failure.Throwable(it)))
    }

    override fun getCharacterDetail(id: String) = flow {
        emit(getCharacterDetailFromService(id))
    }.catch {
        emit(Error(Failure.Throwable(it)))
    }

    private suspend fun getCharactersFromService(): State<CharactersView> {
        return if (networkHandler.isConnected == true) {
            service.getCharacters(10, 0).run {
                if (this.isSuccessful && this.body() != null) {
                    val data = this.body()!!.data
                    Success(data.toCharacters().toCharactersView())
                } else {
                    Error(Failure.ServerError(code()))
                }
            }
        } else {
            Error(Failure.NetworkConnection)
        }
    }

    private suspend fun getCharacterDetailFromService(id:String): State<CharacterView> {
        return if (networkHandler.isConnected == true) {
            service.getCharacterDetail(id).run {
                if (this.isSuccessful && this.body() != null) {
                    this.body()!!.data.results?.let {
                        Success(it.first().toCharacter().toCharacterView())
                    }?: kotlin.run {
                        Error(Failure.CustomError(0, "Couldn't get the character"))
                    }
                } else {
                    Error(Failure.ServerError(code()))
                }
            }
        } else {
            Error(Failure.NetworkConnection)
        }
    }
}