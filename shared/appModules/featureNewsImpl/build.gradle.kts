plugins {
    id("multiplatform-library-convention")
}

android {
    namespace = "com.sychev.feature.news.impl"
}

dependencies {
    api(projects.featureNewsApi)

    implementation(projects.featureBackendApi)
}