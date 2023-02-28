
dependencyResolutionManagement {
    repositories {
        google()
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
include(":shared")
include(":desktopApp")


include(":core")
project(":core").projectDir = File(rootDir, "shared/appModules/core/")
include(":featureBackendApi")
project(":featureBackendApi").projectDir = File(rootDir, "shared/appModules/featureBackendApi/")
include(":featureBackendImpl")
project(":featureBackendImpl").projectDir = File(rootDir, "shared/appModules/featureBackendImpl/")
include(":featureNewsApi")
project(":featureNewsApi").projectDir = File(rootDir, "shared/appModules/featureNewsApi/")
include(":featureNewsImpl")
project(":featureNewsImpl").projectDir = File(rootDir, "shared/appModules/featureNewsImpl/")
