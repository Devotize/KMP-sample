package com.sychev.kmp_sample.core.domain.store

data class Effect(
    val intent: Intent,
    val action: suspend () -> Unit,
)