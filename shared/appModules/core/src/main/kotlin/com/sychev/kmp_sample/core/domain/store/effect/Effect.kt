package com.sychev.kmp_sample.core.domain.store.effect

import com.sychev.kmp_sample.core.domain.store.intent.Intent

data class Effect(
    val intent: Intent,
    val action: suspend () -> Unit,
)