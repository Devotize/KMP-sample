package com.impl.feature.news.di

import com.api.feature.news.domain.interactors.GetNews
import com.api.feature.news.store.NewsStore
import com.impl.feature.news.domain.interactors.GetNewsImpl
import org.koin.dsl.module

fun newsModule() = module {

    single<GetNews> { GetNewsImpl(get()) }

    single {
        NewsStore(
            getNews = get()
        )
    }
}