plugins {
    id("multiplatform-library-convention")
}

android {
    namespace = "com.sychev.feature.news.impl"
}

dependencies {
    api(projects.shared.appModules.featureNewsApi)

    implementation(projects.shared.appModules.featureBackendApi)
}