package di

import domain.interactors.GetNews
import domain.interactors.GetNewsImpl
import org.koin.dsl.module
import store.NewsStore

fun newsModule() = module {

    single<GetNews> { GetNewsImpl(get()) }

    single {
        NewsStore(
            getNews = get()
        )
    }
}