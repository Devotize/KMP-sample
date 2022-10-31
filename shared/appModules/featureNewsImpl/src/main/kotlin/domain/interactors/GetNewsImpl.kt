package domain.interactors

import com.sychev.kmp_sample.backend.api.repository.NewsRepository
import com.sychev.kmp_sample.core.models.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNewsImpl(
    private val newsRepository: NewsRepository
) : GetNews {

    override fun execute(): Flow<List<Article>> = flow {
        emit(newsRepository.getTopHeadlines())
    }
}

