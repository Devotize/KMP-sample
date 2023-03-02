plugins {
    id("multiplatform-library-convention")
}

android {
    namespace = "com.sychev.feature.news.api"
}

dependencies {
    api(projects.shared.appModules.core)
}