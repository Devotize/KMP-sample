plugins {
    kotlin(Plugins.jvm)
}

dependencies {
    api(project(BuildModules.featureNewsApi))

    implementation(project(BuildModules.featureBackendApi))
}