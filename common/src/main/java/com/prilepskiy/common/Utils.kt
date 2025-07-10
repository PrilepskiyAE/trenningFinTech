package com.prilepskiy.common

import kotlinx.coroutines.flow.flow
import kotlin.coroutines.CoroutineContext

fun <T> emitFlow(action: suspend () -> T) = flow { emit(action.invoke()) }

interface CoroutineDispatcherProvider {
    val main: CoroutineContext
    val io: CoroutineContext
}