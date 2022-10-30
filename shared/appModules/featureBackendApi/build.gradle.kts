plugins {
    kotlin(Plugins.jvm)
    kotlin(Plugins.kotlinXSerialization) version Versions.kotlinSerialization
}

dependencies {
    api(project(BuildModules.core))
    api(MultiplatformDependencies.ktorResources)

}