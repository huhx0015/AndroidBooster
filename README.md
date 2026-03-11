Android Booster
===============

DEVELOPER: huhx0015

## Description

**Android Booster** is an Android starter project that provides a modular foundation for building production-ready apps. It offers multiple architecture patterns (MVI, MVVM, MVP, VIPER) with shared base classes, so you can choose the approach that fits each feature.

The project is organized into core modules:

* **Architecture** — Base classes for activities, fragments, and ViewModels; MVI (StateFlow, intents, events), MVVM, MVP, and VIPER contracts; Hilt DI modules; RxBus for event communication
* **Audio** — HX Audio Player integration for music (HXMusic) and sound effects (HXSound) with lifecycle-aware playback
* **Network** — Retrofit, OkHttp, and Gson with a shared `RetrofitInterface` and configurable base URL
* **UI** — ApiRecyclerView activities/fragments for list screens, BindingUtils (Coil image loading), SnackbarUtils, DialogUtils, DisplayUtils, and UnitUtils
* **Common** — AndroidConstants, SharedPreferences, ConnectivityManager, and other app-wide configuration
* **Location** — LocationModule for LocationManager and LocationRequest in services
* **Database** — Reserved for Room or other persistence

Popular libraries include Hilt, Retrofit 2, RxJava 3, RxAndroid, RxRelay, Coil, Leak Canary, Timber, Jetpack (Lifecycle, ViewModel, Data Binding, Compose), and more. The project also includes utility classes and basic test classes for ViewModel testing.

### Claude Skills Support

This project includes **Claude skills** in `claude/skills/` to guide AI-assisted development. When the project is loaded in Claude Code (or compatible tools), these skills provide context on architecture patterns, audio usage, network setup, UI components, and common utilities. See the `claude/skills/` directory for available skills such as `androidbooster-architecture`, `androidbooster-audio`, `androidbooster-network`, and others.

## Resources

### Libraries

Dependencies currently in use in this codebase:

#### Android Jetpack

* [Android Jetpack](https://developer.android.com/jetpack) – Core KTX, AppCompat, Material, Fragment, Lifecycle, Navigation, Paging, WorkManager, Room, Data Binding, Compose (BOM, Material3, Activity, ViewModel)
* [Architecture Components](https://developer.android.com/topic/architecture) – Lifecycle, ViewModel, LiveData

#### Audio

* [HX Audio Player](https://github.com/huhx0015/HXAudioPlayer) – Local AAR (hxaudio-v331)

#### Dependency Injection

* [Hilt](https://dagger.dev/hilt/) – Dagger Hilt with KSP
* [Hilt Navigation Compose](https://developer.android.com/jetpack/androidx/releases/hilt) – Hilt integration for Jetpack Compose

#### Images

* [Coil](https://coil-kt.github.io/coil/) – Image loading (core, SVG, Compose, OkHttp)
* [Subsampling Scale Image View](https://github.com/davemorrissey/subsampling-scale-image-view) – Zoomable image view

#### Logging

* [Timber](https://github.com/JakeWharton/timber) – Logging utility

#### Network

* [OkHttp](https://github.com/square/okhttp) – HTTP client with logging interceptor
* [Retrofit](https://square.github.io/retrofit/) – Type-safe HTTP client with Gson converter and RxJava3 adapter
* [Gson](https://github.com/google/gson) – JSON serialization

#### Persistence

* [Room](https://developer.android.com/training/data-storage/room) – SQLite abstraction with RxJava3 and Guava support

#### Reactive

* [RxJava](https://github.com/ReactiveX/RxJava) – Reactive extensions
* [RxAndroid](https://github.com/ReactiveX/RxAndroid) – RxJava bindings for Android
* [RxRelay](https://github.com/JakeWharton/RxRelay) – RxJava Relay
* [RxBinding](https://github.com/JakeWharton/RxBinding) – RxJava bindings for Android views (core, AppCompat, Material, RecyclerView, etc.)

#### Coroutines

* [Kotlinx Coroutines](https://github.com/Kotlin/kotlinx.coroutines) – Coroutines support for Android

#### Google

* [Guava](https://github.com/google/guava) – Google core libraries (Android)
* [Play Services Location](https://developers.google.com/android/guides/releases) – Location services

#### Performance

* [LeakCanary](https://github.com/square/leakcanary) – Memory leak detection (debug only)

#### Testing

* [JUnit](https://github.com/junit-team/junit4) – Unit testing
* [Mockito](https://github.com/mockito/mockito) – Mocking framework
* [Mockito-Kotlin](https://github.com/nhaarman/mockito-kotlin) – Kotlin extensions for Mockito
* [Robolectric](https://github.com/robolectric/robolectric) – Unit tests for Android
* [Espresso](https://developer.android.com/training/testing/espresso) – UI testing
* [Arch Core Testing](https://developer.android.com/training/testing) – Architecture testing utilities

## License

    Copyright 2026 Michael Huh

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
