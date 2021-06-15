package com.example.utilities.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

abstract class FlowUseCase<T, R>(protected open val coroutineContext: CoroutineContext = Dispatchers.IO) {

    protected abstract fun prepareFlow(input: T?): Flow<R>

    @JvmOverloads
    operator fun invoke(
        params: T? = null
    ): Flow<R> {
        return prepareFlow(params).flowOn(coroutineContext)
    }

    class None

}