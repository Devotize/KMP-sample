object MultiplatformDependencies {

    const val kotlinxSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinxSerialization}"

    const val ktorCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    const val ktorLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    const val ktorResources = "io.ktor:ktor-client-resources:${Versions.ktor}"
    const val ktorNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
    const val ktorJson = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
    const val ktorOkHttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"

    const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
}