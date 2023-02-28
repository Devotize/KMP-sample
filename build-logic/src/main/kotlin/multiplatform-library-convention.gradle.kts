plugins {
    id("com.android.library")
    id("android-base-convention")
    kotlin("multiplatform")
}

kotlin {
    android()
    ios()
    iosSimulatorArm64()
}