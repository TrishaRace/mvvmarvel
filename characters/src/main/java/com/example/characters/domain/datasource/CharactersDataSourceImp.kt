package com.example.characters.domain.datasource

import android.util.Log
import com.example.characters.models.data.Character
import com.example.characters.service.CharacterService
import com.example.platform.NetworkHandler
import com.example.utilities.either.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CharactersDataSourceImp(
    private val networkHandler: NetworkHandler,
    private val service: CharacterService
) : CharactersDataSource {
    override fun getCharacters(
        offset: Int?,
        fromPagination: Boolean
    ) = flow {
        if (networkHandler.isConnected == true) {
            service.getCharacters(10, offset).run {
                Log.i("","run")
                if (this.isSuccessful && this.body() != null) {
                    val data = this.body()!!.data
                    emit(Either.Success( data.toCharacters().toCharactersView()))
                } else {
                    emit(Either.Failure(this.message()))
                }
            }.runCatching {  emit(Either.Failure("Error inesperado"))}
        } else {
            emit(Either.Failure("No hay conexion"))
        }
    }
        .catch { emit(Either.Failure("Error inesperado")) }

    override fun getCharacterDetail(id: String): Flow<Either<Character, String>> = flow {
        service.getCharacter(id).run {
            if (this.isSuccessful && this.body() != null) {
                val data = this.body()
                emit(Either.Success(data!!.toCharacter()))
            } else {
                emit(Either.Failure(this.message()))
            }
        }
    }.catch { emit(Either.Failure("Error inesperado")) }
        .flowOn(Dispatchers.IO)

}

