package store

import com.sychev.kmp_sample.core.domain.store.State
import com.sychev.kmp_sample.core.models.Article
import kotlinx.coroutines.flow.Flow

data class NewsUiState(
    val articles: Flow<List<Article>>
) : State