@file:Suppress("UnstableApiUsage")

plugins {
    id("multiplatform-library-convention")
}

// CocoaPods requires the podspec to have a version.
version = "1.0"

kotlin {

    val iosTarget: (String, org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget.() -> Unit) -> org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget = when {
        System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
        System.getenv("NATIVE_ARCH")?.startsWith("arm") == true -> ::iosSimulatorArm64
        else -> ::iosX64
    }

    iosTarget("ios") {
        binaries {
            framework {
                isStatic = false
                baseName = "shared"
                export(projects.shared.appModules.featureBackendImpl)
                export(projects.shared.appModules.featureNewsImpl)
                export(libs.koinCore)
                transitiveExport = true
            }
        }
    }

    sourceSets {
      commonMain{
            dependencies {
                api(projects.shared.appModules.featureBackendImpl)
                api(projects.shared.appModules.featureNewsImpl)
                api(libs.koinCore)
            }
        }
         androidMain  {
            dependencies {
                api(projects.shared.appModules.featureBackendImpl)
                api(projects.shared.appModules.featureNewsImpl)
                api(libs.koinCore)
            }
        }
        iosMain {
            dependencies {
                implementation(projects.shared.appModules.featureBackendImpl)
                implementation(projects.shared.appModules.featureNewsImpl)
                implementation(libs.koinCore)
            }
        }
    }

}

android {
    compileSdk = Integer.parseInt(project.property("COMPILE_SDK_VERSION") as String)

    defaultConfig {
        minSdk = Integer.parseInt(project.property("MIN_SDK_VERSION") as String)
        targetSdk = Integer.parseInt(project.property("TARGET_SDK_VERSION") as String)
    }
    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
        }
    }
}