import com.android.build.gradle.BaseExtension

configure<BaseExtension> {
    compileSdkVersion(Integer.parseInt(project.property("COMPILE_SDK_VERSION") as String))

    defaultConfig {
        minSdk = Integer.parseInt(project.property("MIN_SDK_VERSION") as String)
        targetSdk = Integer.parseInt(project.property("TARGET_SDK_VERSION") as String)
    }
}
