plugins {
    id("multiplatform-library-convention")
}

android {
    namespace = "com.sychev.core"
}

dependencies {
    api(libs.coroutinesCore)
    api(libs.koinCore)
    api(libs.kotlinxSerialization)
}