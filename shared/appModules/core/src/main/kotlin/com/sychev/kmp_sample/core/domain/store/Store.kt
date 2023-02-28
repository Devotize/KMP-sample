package com.sychev.kmp_sample.core.domain.store

import com.sychev.kmp_sample.core.domain.store.effect.EffectTree
import com.sychev.kmp_sample.core.domain.store.intent.Intent
import com.sychev.kmp_sample.core.domain.store.state.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch

abstract class Store<I : Intent, S : State> {

    protected val storeScope = CoroutineScope(
        Dispatchers.Default + Job()
    )

    abstract val state: S

    protected abstract val effectTree: EffectTree

    fun send(intent: Intent) {
        storeScope.launch {
            effectTree.effects
                .first { effect ->
                    effect.intent == intent
                }.action.invoke()
        }
    }

    protected fun onCleared() {
        storeScope.coroutineContext.cancelChildren()
    }

}