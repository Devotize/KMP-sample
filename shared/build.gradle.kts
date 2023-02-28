@file:Suppress("UnstableApiUsage")

plugins {
    id("multiplatform-library-convention")
}

kotlin {
    android()
    jvm()

    val iosTarget: (String, org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget.() -> Unit) -> org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget = when {
        System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
        System.getenv("NATIVE_kARCH")?.startsWith("arm") == true -> ::iosSimulatorArm64
        else -> ::iosX64
    }
    iosTarget("ios") {}

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.featureBackendImpl)
                implementation(projects.featureNewsImpl)
                implementation(libs.koinCore)
            }
        }
        val commonTest by getting {

        }
        val androidMain by getting {

        }
        val jvmMain by getting {

        }
        iosMain {

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