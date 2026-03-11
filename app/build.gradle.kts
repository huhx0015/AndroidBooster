plugins {
    id("com.android.application")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = 36
    namespace = "com.huhx0015.androidbooster"

    defaultConfig {
        applicationId = "com.huhx0015.androidbooster"
        minSdk = 23
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        buildConfig = true
        compose = true
        dataBinding = true
        viewBinding = true
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

val annotationVersion = "1.9.1"
val cardviewVersion = "1.0.0"
val composeActivityVersion = "1.12.3"
val composeBomVersion = "2026.01.00"
val constraintlayoutVersion = "2.2.1"
val coreKtxVersion = "1.17.0"
val lifecycleVersion = "2.10.0"
val lifecycleExtensionsVersion = "2.2.0"
val materialVersion = "1.13.0"
val navVersion = "2.9.7"
val pagingVersion = "3.4.0"
val workVersion = "2.11.1"
val gsonVersion = "2.13.2"
val guavaVersion = "33.5.0-android"
val hiltNavComposeVersion = "1.3.0"
val findbugsVersion = "3.0.2"
val coilVersion = "3.3.0"
val glideVersion = "4.16.0"
val subsamplingScaleImageViewVersion = "3.10.0"
val timberVersion = "5.0.1"
val moshiVersion = "1.15.2"
val okhttpVersion = "5.3.2"
val retrofitVersion = "3.0.0"
val leakCanaryVersion = "2.14"
val rxandroidVersion = "3.0.2"
val rxbindingVersion = "4.0.0"
val rxjavaVersion = "3.1.12"
val rxrelayVersion = "3.0.1"
val espressoVersion = "3.6.1"
val runnerVersion = "1.7.0"
val coreTestingVersion = "2.2.0"
val junitVersion = "4.13.2"
val rulesVersion = "1.7.0"
val mockitoVersion = "5.21.0"
val mockitoKotlinVersion = "6.2.3"
val robolectricVersion = "4.16.1"
val hiltVersion = rootProject.extra["hilt_version"] as String

dependencies {
    // ---------------------------------------------------------------------------------------------
    // CORE DEPENDENCIES
    // ---------------------------------------------------------------------------------------------

    // ANDROID JETPACK
    implementation("androidx.annotation:annotation:$annotationVersion")
    implementation("androidx.cardview:cardview:$cardviewVersion")
    implementation("androidx.constraintlayout:constraintlayout:$constraintlayoutVersion")
    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-extensions:$lifecycleExtensionsVersion")
    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:$lifecycleVersion")
    implementation("com.google.android.material:material:$materialVersion")
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")
    implementation("androidx.paging:paging-runtime-ktx:$pagingVersion")
    implementation("androidx.paging:paging-rxjava3:$pagingVersion")
    implementation("androidx.work:work-runtime-ktx:$workVersion")
    implementation("androidx.work:work-rxjava3:$workVersion")

    // CORE MODULES
    implementation(project(":core:network"))
    implementation(project(":core:audio"))
    implementation(project(":core:database"))
    implementation(project(":core:architecture"))
    implementation(project(":core:ui"))
    implementation(project(":core:location"))
    implementation(project(":core:common"))

    // COMPOSE
    implementation(platform("androidx.compose:compose-bom:$composeBomVersion"))
    implementation("androidx.compose.animation:animation-graphics")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.runtime:runtime-livedata")
    implementation("androidx.activity:activity-compose:$composeActivityVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion")

    // DEPENDENCY INJECTION
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:$hiltNavComposeVersion")
    ksp("com.google.dagger:hilt-android-compiler:$hiltVersion")
    ksp("com.google.dagger:hilt-compiler:$hiltVersion")

    // GOOGLE
    implementation("com.google.code.gson:gson:$gsonVersion")
    api("com.google.guava:guava:$guavaVersion")

    // GOOGLE PLAY SERVICES (play-services-location provided by core:location)

    // IMAGE
    implementation("io.coil-kt.coil3:coil:$coilVersion")
    implementation("io.coil-kt.coil3:coil-svg:$coilVersion")
    implementation("io.coil-kt.coil3:coil-compose:$coilVersion")
    implementation("io.coil-kt.coil3:coil-network-okhttp:$coilVersion")
    implementation("com.davemorrissey.labs:subsampling-scale-image-view:$subsamplingScaleImageViewVersion")

    // LOGGING
    implementation("com.jakewharton.timber:timber:$timberVersion")

    // MOSHI
    implementation("com.squareup.moshi:moshi:$moshiVersion")
    implementation("com.squareup.moshi:moshi-kotlin:$moshiVersion")
    implementation("com.squareup.moshi:moshi-adapters:$moshiVersion")
    ksp("com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion")

    // PERFORMANCE
    debugImplementation("com.squareup.leakcanary:leakcanary-android:$leakCanaryVersion")

    // RXJAVA
    implementation("com.jakewharton.rxbinding4:rxbinding:$rxbindingVersion")
    implementation("com.jakewharton.rxbinding4:rxbinding-core:$rxbindingVersion")
    implementation("com.jakewharton.rxbinding4:rxbinding-appcompat:$rxbindingVersion")
    implementation("com.jakewharton.rxbinding4:rxbinding-drawerlayout:$rxbindingVersion")
    implementation("com.jakewharton.rxbinding4:rxbinding-material:$rxbindingVersion")
    implementation("com.jakewharton.rxbinding4:rxbinding-recyclerview:$rxbindingVersion")
    implementation("com.jakewharton.rxbinding4:rxbinding-slidingpanelayout:$rxbindingVersion")
    implementation("com.jakewharton.rxbinding4:rxbinding-swiperefreshlayout:$rxbindingVersion")
    implementation("com.jakewharton.rxbinding4:rxbinding-viewpager:$rxbindingVersion")
    implementation("com.jakewharton.rxrelay3:rxrelay:$rxrelayVersion")
    implementation("io.reactivex.rxjava3:rxandroid:$rxandroidVersion")
    implementation("io.reactivex.rxjava3:rxjava:$rxjavaVersion")

    // ---------------------------------------------------------------------------------------------
    // TEST DEPENDENCIES
    // ---------------------------------------------------------------------------------------------

    // ANDROID JETPACK
    testImplementation("androidx.arch.core:core-testing:$coreTestingVersion")
    testImplementation("androidx.paging:paging-common-ktx:$pagingVersion")
    androidTestImplementation("androidx.work:work-testing:$workVersion")

    // UI TESTING
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion") {
        exclude(group = "com.google.code.findbugs", module = "jsr305")
    }
    androidTestImplementation("androidx.test:runner:$runnerVersion")

    // UNIT TESTING
    androidTestImplementation("junit:junit:$junitVersion")
    testImplementation("junit:junit:$junitVersion")
    androidTestImplementation("androidx.test:rules:$rulesVersion")
    androidTestImplementation("org.mockito:mockito-core:$mockitoVersion")
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
    androidTestImplementation("org.mockito.kotlin:mockito-kotlin:$mockitoKotlinVersion")
    testImplementation("org.mockito.kotlin:mockito-kotlin:$mockitoKotlinVersion")
    testImplementation("org.robolectric:robolectric:$robolectricVersion")
}
