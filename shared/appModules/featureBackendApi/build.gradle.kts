@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("multiplatform-library-convention")
    kotlin("plugin.serialization") version libs.versions.kotlinSerializationVersion.get()
}

android {
    namespace = "com.sychev.feature.backend.api"
}

dependencies {
    api(projects.shared.appModules.core)
    api(libs.ktorResources)

}