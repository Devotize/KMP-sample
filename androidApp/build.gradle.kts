@file:Suppress("UnstableApiUsage")

plugins {
    id("android-app-convention")
    id("com.android.application")
    kotlin("android")
}

android {
    defaultConfig {
        applicationId = "com.sychev.kmp_sample.android"
        versionCode = Integer.parseInt(project.property("VERSION_CODE") as String)
        versionName = project.property("VERSION_NAME") as String
    }
    packagingOptions {
        resources {
            pickFirsts.add("lib/x86_64/libjsc.so")
            pickFirsts.add("lib/arm64-v8a/libjsc.so")
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
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
        kotlinCompilerExtensionVersion = libs.versions.kotlinKompilerVersion.get()
    }
}

dependencies {
    api(projects.shared)

    implementation(libs.androidCore)
    implementation(libs.material)
    implementation(libs.koinAndroid)
    implementation(libs.koinCompose)

    implementation(libs.composeUI)
    implementation(libs.composeMaterial)
    implementation(libs.composeMaterial3)
    implementation(libs.composeActivity)
    implementation(libs.composeToolingPreview)
    implementation(libs.composeRuntime)
    implementation(libs.composeUtil)
    implementation(libs.coilCompose)
    implementation(projects.featureNewsApi)

    debugImplementation(libs.composeTooling)

}