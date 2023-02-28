plugins {
    kotlin("jvm")
}

dependencies {
    implementation(projects.featureBackendApi)

    implementation(libs.koinCore)

    implementation(libs.ktorLogging)
    implementation(libs.ktorCore)
    implementation(libs.ktorNegotiation)
    implementation(libs.ktorJson)
    implementation(libs.ktorOkHttp)
}