@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version libs.versions.kotlinSerializationVersion.get()
}

dependencies {
    api(projects.core)
    api(libs.ktorResources)

}