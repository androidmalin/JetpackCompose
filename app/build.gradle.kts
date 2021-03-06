/*
 * Copyright 2019 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")
    defaultConfig {
        resConfigs("en")
        applicationId = "com.example.jetpackcompose"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
        ndk {
            abiFilters("arm64-v8a", "x86")
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("debug") {
            isMinifyEnabled = false
            isZipAlignEnabled = false
            isShrinkResources = false
            isCrunchPngs = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    //https://github.com/gradle/gradle/issues/11083
    withGroovyBuilder {
        "kotlinOptions" {
            setProperty("jvmTarget", "1.8")
        }
    }

    buildFeatures {
        compose = true
    }
}

val ktlint by configurations.creating

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.60-eap-25")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.activity:activity-ktx:1.1.0-rc02")
    implementation("androidx.core:core-ktx:1.2.0-rc01")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("com.google.android.material:material:1.0.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.android.support.constraint:constraint-layout:1.1.3")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    implementation("androidx.gridlayout:gridlayout:1.0.0")

    val composeVersion = "0.1.0-dev02"
    implementation("androidx.compose:compose-runtime:$composeVersion")
    implementation("androidx.ui:ui-framework:$composeVersion")
    implementation("androidx.ui:ui-layout:$composeVersion")
    implementation("androidx.ui:ui-material:$composeVersion")
    implementation("androidx.ui:ui-tooling:$composeVersion")

    implementation("androidx.ui:ui-core:$composeVersion")
    implementation("androidx.ui:ui-animation:$composeVersion")
    implementation("androidx.ui:ui-animation-core:$composeVersion")
    implementation("androidx.ui:ui-android-text:$composeVersion")
    implementation("androidx.ui:ui-platform:$composeVersion")
    implementation("androidx.ui:ui-vector:$composeVersion")
    implementation("androidx.ui:ui-foundation:$composeVersion")
    implementation("androidx.ui:ui-text:$composeVersion")
    implementation("androidx.ui:ui-test:$composeVersion")

    ktlint("com.pinterest:ktlint:0.35.0")
}

tasks.register<JavaExec>("ktlint") {
    group = "verification"
    description = "Check Kotlin code style."
    main = "com.pinterest.ktlint.Main"
    classpath = configurations.getByName("ktlint")
    args = listOf("src/**/*.kt")
}

tasks.getByName("check").dependsOn(tasks.getByName("ktlint"))

tasks.register<JavaExec>("ktlintFormat") {
    group = "formatting"
    description = "Fix Kotlin code style deviations."
    main = "com.pinterest.ktlint.Main"
    classpath = configurations.getByName("ktlint")
    args = listOf("-F", "src/**/*.kt")
}
