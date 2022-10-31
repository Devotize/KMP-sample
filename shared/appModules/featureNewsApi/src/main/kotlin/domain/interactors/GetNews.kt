package domain.interactors

import com.sychev.kmp_sample.core.models.Article
import kotlinx.coroutines.flow.Flow

interface GetNews {

    fun execute(): Flow<List<Article>>

}