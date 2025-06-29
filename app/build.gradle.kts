plugins {
    id("com.android.application")
    id("kotlin-android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.example.feast"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.feast"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:${libs.versions.appcompat.get()}")
    implementation("androidx.core:core-splashscreen:1.0.1")

    implementation("androidx.core:core-ktx:${libs.versions.coreKtx.get()}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${libs.versions.lifecycleRuntimeKtx.get()}")

    val composeBom = platform("androidx.compose:compose-bom:${libs.versions.composeBom.get()}")
    implementation(composeBom)

    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.activity:activity-compose:1.10.1")
    implementation("androidx.navigation3:navigation3-runtime:${libs.versions.nav3Core}")
    implementation("androidx.navigation3:navigation3-ui:${libs.versions.nav3Core}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-navigation3:${libs.versions.lifecycleViewmodelNav3}")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:${libs.versions.androidx.lifecycle.get()}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${libs.versions.androidx.lifecycle.get()}")
    implementation("androidx.lifecycle:lifecycle-process:${libs.versions.androidx.lifecycle.get()}")
    implementation("androidx.hilt:hilt-navigation-compose:${libs.versions.hiltNavigationCompose.get()}")

    implementation("com.google.dagger:hilt-android:2.56.2")
    kapt("com.google.dagger:hilt-android-compiler:2.56.2")

    implementation("com.jakewharton.timber:timber:${libs.versions.jakewhartonTimber.get()}")

    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.lifecycle.viewmodel.navigation3)
    implementation(libs.kotlinx.serialization.core)
}