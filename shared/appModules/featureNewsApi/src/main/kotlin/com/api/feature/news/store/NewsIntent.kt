package com.api.feature.news.store

import com.sychev.kmp_sample.core.domain.store.intent.Intent

sealed class NewsIntent : Intent

object LoadNews : NewsIntent()