rootProject.name = "KMP-sample"
include(":androidApp")
include(":shared")
include(":desktopApp")
include(":FeatureBackendApi")
project(":FeatureBackendApi").projectDir = File(rootDir, "shared/FeatureBackendApi")
