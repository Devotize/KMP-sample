rootProject.name = "KMP-sample"
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
