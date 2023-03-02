
dependencyResolutionManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://developer.huawei.com/repo/")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }
}



rootProject.name = "KMP-sample"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

includeBuild("build-logic")

include(":androidApp")
include(":desktopApp")
include(":shared")
include(":shared:appModules:core")
include(":shared:appModules:featureBackendApi")
include(":shared:appModules:featureBackendImpl")
include(":shared:appModules:featureNewsApi")
include(":shared:appModules:featureNewsImpl")
