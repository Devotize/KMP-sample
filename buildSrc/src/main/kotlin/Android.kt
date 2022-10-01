object AndroidSdk {
    const val compileSdk = 33
    const val minSdk = 24
    const val targetSdk = 33
    const val versionCode = 100000
    const val vesrionName = "1.0.0"
}

object AndroidDependencies {
    //core
    const val androidCore = "androidx.core:core-ktx:${Versions.androidCore}"
    const val material = "com.google.android.material:material:${Versions.material}"

    // compose
    const val composeUI = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeTooling = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeRuntime =
        "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val composeUtil = "androidx.compose.ui:ui-util:${Versions.compose}"
    const val composeActivity =
        "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val composeMaterial3 = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
}