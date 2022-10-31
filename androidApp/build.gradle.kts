@file:Suppress("UnstableApiUsage")

plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.android)
}

android {
    compileSdk = AndroidSdk.compileSdk
    defaultConfig {
        applicationId = "com.sychev.kmp_sample.android"
        minSdk = AndroidSdk.minSdk
        targetSdk = AndroidSdk.targetSdk
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.vesrionName
    }
    packagingOptions {
        resources {
            pickFirsts.add("lib/x86_64/libjsc.so")
            pickFirsts.add("lib/arm64-v8a/libjsc.so")
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }

    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinKompiler
    }
}

dependencies {
    api(project(BuildModules.shared))

    implementation(AndroidDependencies.androidCore)
    implementation(AndroidDependencies.material)

    implementation(AndroidDependencies.koinAndroid)
    implementation(AndroidDependencies.koinCompose)

    implementation(AndroidDependencies.composeUI)
    implementation(AndroidDependencies.composeMaterial)
    implementation(AndroidDependencies.composeMaterial3)
    implementation(AndroidDependencies.composeActivity)
    implementation(AndroidDependencies.composeTooling)
    implementation(AndroidDependencies.composeRuntime)
    implementation(AndroidDependencies.composeUtil)

}