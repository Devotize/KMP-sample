plugins {
    kotlin(Plugins.jvm)
}

dependencies {
    implementation(project(BuildModules.featureBackendApi))

    implementation(MultiplatformDependencies.koinCore)

    implementation(MultiplatformDependencies.ktorLogging)
    implementation(MultiplatformDependencies.ktorNegotiation)
    implementation(MultiplatformDependencies.ktorJson)
}