@file:Suppress("UnstableApiUsage")

plugins {
    kotlin("multiplatform")
    id("com.android.library")
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

//    listOf(
//        iosX64(),
//        iosArm64(),
//        iosSimulatorArm64()
//    ).forEach {
//        it.binaries.framework {
//            baseName = "shared"
//        }
//    }

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
//        val iosX64Main by getting
//        val iosArm64Main by getting
//        val iosSimulatorArm64Main by getting
//        val iosMain by creating {
//            dependsOn(commonMain)
//            iosX64Main.dependsOn(this)
//            iosArm64Main.dependsOn(this)
//            iosSimulatorArm64Main.dependsOn(this)
//        }
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