package com.example.utilities.usecase

import kotlinx.coroutines.flow.Flow

abstract class FlowUseCase<in Params, out Type> where Type : Any? {

    abstract suspend fun prepareFlow(params: Params? = null): Flow<Type>

    @JvmOverloads
    suspend operator fun invoke(
        params: Params? = null
    ): Flow<Type> {
        return prepareFlow(params)
    }

    class None
}