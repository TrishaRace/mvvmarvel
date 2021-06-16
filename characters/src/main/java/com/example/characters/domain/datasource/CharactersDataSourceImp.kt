package com.example.characters.domain.datasource

import com.example.characters.models.view.CharactersView
import com.example.characters.service.CharacterService
import com.example.exception.Failure
import com.example.platform.NetworkHandler
import com.example.utilities.State
import com.example.utilities.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import com.example.utilities.Error

class CharactersDataSourceImp(
    private val networkHandler: NetworkHandler,
    private val service: CharacterService
) : CharactersDataSource {
    override fun getCharacters(
        offset: Int?,
        fromPagination: Boolean
    ) = flow {
        emit(getCharactersFromService())
    }
        .catch {
            emit(Error(Failure.Throwable(it)))
        }
        .flowOn(Dispatchers.IO)

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
}

