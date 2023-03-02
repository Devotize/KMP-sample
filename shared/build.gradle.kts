@file:Suppress("UnstableApiUsage")

plugins {
    id("multiplatform-library-convention")
//    id("org.jetbrains.kotlin.native.cocoapods")
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
                baseName = "shared"
                export(projects.shared.appModules.featureBackendImpl)
                export(projects.shared.appModules.featureNewsImpl)
                export(libs.koinCore)
            }
        }
    }

//    listOf(
//        iosX64(),
//        iosArm64(),
//        iosSimulatorArm64()
//    ).forEach {
//        it.binaries.framework {
//            baseName = "shared"
//        }
//    }

//    cocoapods {
//        // Configure fields required by CocoaPods.
//        summary = "KMP-SAMPLE"
//        homepage = ""
//
//        framework {
//            // Required properties
//            // Framework name configuration. Use this property instead of deprecated 'frameworkName'
//            baseName = "shared"
//
//            // Optional properties
//            // Specify the framework linking type. It's dynamic by default.
//            isStatic = false
//            // Dependency export
//            export(projects.shared.appModules.featureBackendImpl)
//            export(projects.shared.appModules.featureNewsImpl)
//            transitiveExport = false // This is default.
//            // Bitcode embedding
//            embedBitcode(org.jetbrains.kotlin.gradle.plugin.mpp.BitcodeEmbeddingMode.BITCODE)
//        }
//
//        // Maps custom Xcode configuration to NativeBuildType
//        xcodeConfigurationToNativeBuildType["CUSTOM_DEBUG"] =
//            NativeBuildType.DEBUG
//        xcodeConfigurationToNativeBuildType["CUSTOM_RELEASE"] =
//            NativeBuildType.RELEASE
//
//    }

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