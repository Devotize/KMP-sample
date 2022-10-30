package di

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.resources.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.named
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module
import utils.NEWS_API_BASE_URL
import utils.api_key.newsApiKey

fun backendModule() = module {

    single {
        HttpClient {
            defaultRequest {
                url {
                    host = NEWS_API_BASE_URL
                    url { protocol = URLProtocol.HTTPS }
                    parameters.append("apiKey", newsApiKey)
                }
            }
            install(Resources)
            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        println("HTTP: $message") //TODO add multiplatform logger
                    }
                }
            }
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    }
                )
            }
        }
    } withOptions {
        named(QualifierNames.news_api_client)
    }

}