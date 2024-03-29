plugins {
    id("multiplatform-library-convention")
}

android {
    namespace = "com.sychev.feature.backend.impl"
}

dependencies {
    implementation(projects.shared.appModules.featureBackendApi)

    implementation(libs.koinCore)

    implementation(libs.ktorLogging)
    implementation(libs.ktorCore)
    implementation(libs.ktorNegotiation)
    implementation(libs.ktorJson)
    implementation(libs.ktorOkHttp)
}