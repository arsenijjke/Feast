// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version libs.versions.agpVersion.get() apply false
    id("com.android.library") version libs.versions.agpVersion.get() apply false
    id("org.jetbrains.kotlin.android") version libs.versions.kotlin.get() apply false
    id("org.jetbrains.kotlin.plugin.compose") version libs.versions.kotlin.get() apply false
    id("org.jetbrains.kotlin.jvm") version libs.versions.kotlin.get() apply false
    id("com.google.dagger.hilt.android") version libs.versions.hilt.get() apply false
    id("com.google.devtools.ksp") version libs.versions.ksp.get() apply false
    id("org.jetbrains.kotlin.plugin.serialization") version libs.versions.kotlinSerialization.get() apply false
}

buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}