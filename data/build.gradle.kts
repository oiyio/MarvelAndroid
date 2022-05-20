plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlinx-serialization")
    id("androidx.navigation.safeargs")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}


android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk

        if (project.hasProperty("marvel_public_api_key")) {
            val marvelPublicKey = "${project.property("marvel_public_api_key")}"
            val marvelPrivateKey = "${project.property("marvel_private_api_key")}"
            buildConfigField("String", "MARVEL_PUBLIC_API_KEY", marvelPublicKey)
            buildConfigField("String", "MARVEL_PRIVATE_API_KEY", marvelPrivateKey)
        } else {
            // the app needs `marvel_public_api_key` and `marvel_private_api_key`
            // as gradle properties to run
            // to get one visit: https://developer.marvel.com/account
            throw GradleException("Please provide the Marvel API keys as gradle properties")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:${Versions.coreKtxVersion}")
    implementation("androidx.appcompat:appcompat:${Versions.appcompatVersion}")
    implementation("com.google.android.material:material:${Versions.materialVersion}")

    networkDependencies()

    hiltDependencies()

    // Gson
    implementation("com.google.code.gson:gson:${Versions.gsonVersion}")

    roomDependencies()

    debugImplementation("com.github.chuckerteam.chucker:library:3.5.2")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:3.5.2")

    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
}