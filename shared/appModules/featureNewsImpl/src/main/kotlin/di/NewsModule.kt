package di

import domain.interactors.GetNews
import domain.interactors.GetNewsImpl
import org.koin.dsl.module

fun newsModule() = module {

    single<GetNews> { GetNewsImpl(get()) }
}