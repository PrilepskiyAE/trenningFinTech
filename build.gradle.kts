// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.dagger.hilt) apply false
    alias(libs.plugins.android.serialization) apply false
    alias(libs.plugins.google.services) apply false
    alias(libs.plugins.org.jetbrains.kotlin.kapt) apply false
    id("com.google.devtools.ksp") version "2.2.0-2.0.2" apply false
}