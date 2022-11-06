package store

import com.sychev.kmp_sample.core.domain.store.Intent

sealed class NewsIntent : Intent

object LoadNews : NewsIntent()