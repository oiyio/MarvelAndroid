import extension.implementation
import extension.kapt
import extension.testImplementation
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.composeDependencies() {

    implementation("androidx.compose.ui:ui:${Versions.composeVersion}")
    implementation("androidx.compose.ui:ui-tooling:${Versions.composeVersion}")
    implementation("androidx.compose.material:material:${Versions.composeVersion}")
    implementation("androidx.compose.material:material-icons-extended:${Versions.composeVersion}")
    implementation("androidx.compose.runtime:runtime:${Versions.composeVersion}")

    implementation("androidx.activity:activity-compose:1.4.0")

    implementation("androidx.navigation:navigation-compose:2.4.1")

    // because("i wannna use observeAsState()")
    implementation("androidx.compose.runtime:runtime-livedata:${Versions.composeVersion}")

    implementation("androidx.navigation:navigation-compose:2.4.0-beta02")
}

fun DependencyHandler.hiltDependencies() {
    // dagger hilt
    implementation("com.google.dagger:hilt-android:${Versions.hiltVersion}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}")
}

fun DependencyHandler.networkDependencies() {
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}")
    implementation("com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}")
    /*implementation ("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:1.0.0")*/

    // OkHttp
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    // Moshi
    implementation("com.squareup.moshi:moshi:${Versions.moshiVersion}")
    implementation("com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}")
    implementation("com.squareup.moshi:moshi-adapters:${Versions.moshiVersion}")
}


fun DependencyHandler.roomDependencies() {
    //Room
    implementation("androidx.room:room-runtime:${Versions.room}")
    kapt("androidx.room:room-compiler:${Versions.room}")
    implementation("androidx.room:room-ktx:${Versions.room}") // optional - Kotlin Extensions and Coroutines support for Room
    testImplementation("androidx.room:room-testing:${Versions.room}") // optional - Test helpers
}

