plugins {
    kotlin(Plugins.jvm)
    id(Plugins.compose) version Versions.composeDesktop
}

compose.desktop {
    application {
        mainClass = "MainKt"
    }
}

dependencies {
    implementation(compose.desktop.currentOs)
    api(project(BuildModules.shared))
}