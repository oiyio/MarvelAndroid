plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlinx-serialization")
    id("androidx.navigation.safeargs")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "com.omeriyioz.marvel"
        minSdk = 21
        targetSdk = Versions.targetSdk
        vectorDrawables.useSupportLibrary = true
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions { jvmTarget = "1.8" }

    buildFeatures {
        compose = true
        dataBinding = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeVersion
    }
}

dependencies {
    // implementation (fileTree(dir: 'libs', include: ['*.jar']))

    api(project(":data"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}")
    implementation("androidx.core:core-ktx:${Versions.coreKtxVersion}")
    implementation("androidx.appcompat:appcompat:${Versions.appcompatVersion}")
    implementation("com.google.android.material:material:${Versions.materialVersion}")
    implementation("androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}")

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}")
    //implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

    // ViewModel and LiveData
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")

    composeDependencies()

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}")
    implementation("androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}")

    networkDependencies()
    hiltDependencies()

    // Gson
    implementation("com.google.code.gson:gson:${Versions.gsonVersion}")

    // Glide
    implementation("com.github.bumptech.glide:glide:${Versions.glideVersion}")
    annotationProcessor("com.github.bumptech.glide:compiler:${Versions.glideVersion}")

}

