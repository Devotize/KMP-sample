buildscript {
    repositories {
        mavenCentral()
        google()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(Plugins.gradle)
        classpath(Plugins.kotlin)
    }
}

allprojects {
    repositories {
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        maven("https://plugins.gradle.org/m2/")
    }
}

tasks.register("clean").configure {
    delete("build")
}


//kotlin {
//    jvm("desktop")
//    android()
//    js(IR) {
//        browser()
//        binaries.executable()
//    }
//
//    macosX64 {
//        binaries {
//            executable {
//                entryPoint = "main"
//                freeCompilerArgs = freeCompilerArgs + listOf(
//                    "-linker-option", "-framework", "-linker-option", "Metal"
//                )
//            }
//        }
//    }
//    macosArm64 {
//        binaries {
//            executable {
//                entryPoint = "main"
//                freeCompilerArgs = freeCompilerArgs + listOf(
//                    "-linker-option", "-framework", "-linker-option", "Metal"
//                )
//            }
//        }
//    }
//    iosX64("uikitX64") {
//        binaries {
//            executable {
//                entryPoint = "main"
//                freeCompilerArgs = freeCompilerArgs + listOf(
//                    "-linker-option", "-framework", "-linker-option", "Metal",
//                    "-linker-option", "-framework", "-linker-option", "CoreText",
//                    "-linker-option", "-framework", "-linker-option", "CoreGraphics"
//                )
//            }
//        }
//    }
//    iosArm64("uikitArm64") {
//        binaries {
//            executable {
//                entryPoint = "main"
//                freeCompilerArgs = freeCompilerArgs + listOf(
//                    "-linker-option", "-framework", "-linker-option", "Metal",
//                    "-linker-option", "-framework", "-linker-option", "CoreText",
//                    "-linker-option", "-framework", "-linker-option", "CoreGraphics"
//                )
//                // TODO: the current compose binary surprises LLVM, so disable checks for now.
//                freeCompilerArgs = freeCompilerArgs + "-Xdisable-phases=VerifyBitcode"
//            }
//        }
//    }
//
//    sourceSets {
//        val commonMain by getting {
//            dependencies {
//                implementation(compose.ui)
//                implementation(compose.foundation)
//                implementation(compose.material)
//                implementation(compose.runtime)
//            }
//        }
//
//        val commonTest by getting {
//            dependencies {
//                implementation(kotlin("test-common"))
//                implementation(kotlin("test-annotations-common"))
//            }
//        }
//
//        val desktopMain by getting {
//            dependencies {
//                implementation(compose.desktop.currentOs)
//            }
//        }
//
//        val androidMain by getting {
//            dependsOn(commonMain)
//            dependencies {
//                implementation("androidx.appcompat:appcompat:1.5.1")
//                implementation("androidx.core:core-ktx:1.9.0")
//            }
//        }
//
//        val jsMain by getting {
//            dependencies {
//
//            }
//        }
//
//        val iosMain by creating {
//            dependsOn(commonMain)
//        }
//        val macosMain by creating {
//            dependsOn(iosMain)
//        }
//        val macosX64Main by getting {
//            dependsOn(macosMain)
//        }
//        val macosArm64Main by getting {
//            dependsOn(macosMain)
//        }
//        val uikitMain by creating {
//            dependsOn(iosMain)
//        }
//        val uikitX64Main by getting {
//            dependsOn(uikitMain)
//        }
//        val uikitArm64Main by getting {
//            dependsOn(uikitMain)
//        }
//    }
//}
//
//
//android {
//    compileSdk = AndroidSdk.compileSdk
//
//    defaultConfig {
//        minSdk = AndroidSdk.minSdk
//        targetSdk = AndroidSdk.targetSdk
//    }
//    sourceSets {
//        named("main") {
//            manifest.srcFile("src/androidMain/src/main/AndroidManifest.xml")
//            res.srcDirs("src/androidMain/src/main/res", "src/commonMain/resources")
//            assets.srcDirs("src/androidMain/src/main/assets", "src/commonMain/assets")
//        }
//    }
//}
//
//compose.desktop {
//    application {
//        mainClass = "Main_desktopKt"
//
//        nativeDistributions {
//            targetFormats(
//                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg,
//                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi,
//                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb
//            )
//            packageName = "KMP-SAMPLE"
//            packageVersion = "1.0.0"
//
//            windows {
//                menuGroup = "Compose Examples"
//                // see https://wixtoolset.org/documentation/manual/v3/howtos/general/generate_guids.html
//                upgradeUuid = "18159995-d967-4CD2-8885-77BFA97CFA9F"
//            }
//        }
//    }
//}
//
///**
// * Workaround for error CFBundleVersion ot install stage:
// * move Info.plot to [prjectName.app] and change CFBundleExecutable to [projectName]
// */
//compose.experimental {
//    web.application {}
//    uikit.application {
//        bundleIdPrefix = "com.sychev"
//        projectName = "KMP-SAMPLE"
//        deployConfigurations {
//            simulator("IPhone8") {
//                //Usage: ./gradlew iosDeployIPhone8Debug
//                device = org.jetbrains.compose.experimental.dsl.IOSDevices.IPHONE_8
//            }
//            simulator("IPadUI") {
//                //Usage: ./gradlew iosDeployIPadUIDebug
//                device = org.jetbrains.compose.experimental.dsl.IOSDevices.IPAD_MINI_6th_Gen
//            }
//        }
//    }
//}
//
//tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
//    kotlinOptions.jvmTarget = "11"
//}
//
//kotlin {
//    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
//        binaries.all {
//            // TODO: the current compose binary surprises LLVM, so disable checks for now.
//            freeCompilerArgs = freeCompilerArgs + "-Xdisable-phases=VerifyBitcode"
//        }
//    }
//}
//
//compose.desktop.nativeApplication {
//    targets(kotlin.targets.getByName("macosX64"))
//    distributions {
//        targetFormats(org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg)
//        packageName = "KMP-SAMPLE"
//        packageVersion = "1.0.0"
//    }
//}
//
//// a temporary workaround for a bug in jsRun invocation - see https://youtrack.jetbrains.com/issue/KT-48273
//afterEvaluate {
//    rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
//        versions.webpackDevServer.version = "4.0.0"
//        versions.webpackCli.version = "4.10.0"
//        nodeVersion = "16.0.0"
//    }
//}
////
//
//// TODO: remove when https://youtrack.jetbrains.com/issue/KT-50778 fixed
//project.tasks.withType(org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile::class.java).configureEach {
//    kotlinOptions.freeCompilerArgs += listOf(
//        "-Xir-dce-runtime-diagnostic=log"
//    )
//}