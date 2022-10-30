rootProject.name = "KMP-sample"
include(":androidApp")
include(":shared")
include(":desktopApp")


include(":core")
project(":core").projectDir = File(rootDir, "shared/buildModules/core/")
include(":featureBackendApi")
project(":featureBackendApi").projectDir = File(rootDir, "shared/buildModules/featureBackendApi/")
include(":featureBackendImpl")
project(":featureBackendImpl").projectDir = File(rootDir, "shared/buildModules/featureBackendImpl/")
