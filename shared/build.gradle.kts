@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin(Plugins.multiplatform)
    id(Plugins.androidLibrary)
}

kotlin {
    android()
    jvm()

//    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget = when {
//        System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
//        System.getenv("NATIVE_kARCH")?.startsWith("arm") == true -> ::iosSimulatorArm64
//        else -> ::iosX64
//    }
//    iosTarget("iOS") {}

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(BuildModules.featureBackendApi))
                implementation(project(BuildModules.featureBackendImpl))
            }
        }
        val commonTest by getting {

        }
        val androidMain by getting {

        }
        val jvmMain by getting {

        }
//        val iOSMain by getting {
//
//        }
    }

}

android {
    compileSdk = AndroidSdk.compileSdk

    defaultConfig {
        minSdk = AndroidSdk.minSdk
        targetSdk = AndroidSdk.targetSdk
    }
    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
        }
    }
}