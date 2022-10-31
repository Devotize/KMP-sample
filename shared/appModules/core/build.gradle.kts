plugins {
    kotlin(Plugins.jvm)
}

dependencies {
    api(MultiplatformDependencies.coroutinesCore)
    api(MultiplatformDependencies.koinCore)
    api(MultiplatformDependencies.kotlinxSerialization)
}