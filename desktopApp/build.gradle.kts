@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    kotlin("jvm")
    id("org.jetbrains.compose") version libs.versions.composeDesktopVersion.get()
}

compose.desktop {
    application {
        mainClass = "MainKt"
    }
}

dependencies {
    implementation(compose.desktop.currentOs)
    api(projects.shared)
}