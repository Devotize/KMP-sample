plugins {
    kotlin("jvm")
}

dependencies {
    api(projects.featureNewsApi)

    implementation(projects.featureBackendApi)
}