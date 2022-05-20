To run this project, you must add the following to "project gradle properties" or "global gradle properties" :
marvel_public_api_key="blah blah"
marvel_private_api_key="blah blah"

This android app uses Marvel Comics APIs described in https://developer.marvel.com/

This app demonstrates the following views and techniques:

* [Multimodule architecture](https://developer.android.com/guide/navigation/navigation-multi-module) for multimodule architecture.
* [Retrofit](https://square.github.io/retrofit/) to make api calls to an HTTP web service.
* [Moshi](https://github.com/square/moshi) which handles the deserialization of the returned JSON to Kotlin data objects. 
* [Glide](https://bumptech.github.io/glide/) to load and cache images by URL.
* [Room](https://developer.android.com/training/data-storage/room) for local database storage.
* [Jetpack Compose](https://developer.android.com/jetpack/compose) for Jetpack Compose
* [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) with the SafeArgs plugin for parameter passing between fragments
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection
* [Kotlin DSL Gradle](https://docs.gradle.org/current/userguide/kotlin_dsl.html) for Gradle
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* [Data Binding](https://developer.android.com/topic/libraries/data-binding/) with binding adapters
* [View Binding](https://developer.android.com/topic/libraries/data-binding/) with binding adapters
* [Spotless](https://github.com/diffplug/spotless) for Spotless with ktlint formatting
