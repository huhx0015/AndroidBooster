buildscript {
    extra.apply {
        set("android_plugin_version", "9.0.0")
        set("hilt_version", "2.59.1")
        set("kotlin_version", "2.2.21")
        set("ksp_version", "2.3.2")
    }
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${rootProject.extra["android_plugin_version"]}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${rootProject.extra["kotlin_version"]}")
        classpath("org.jetbrains.kotlin:compose-compiler-gradle-plugin:${rootProject.extra["kotlin_version"]}")
        classpath("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:${rootProject.extra["ksp_version"]}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${rootProject.extra["hilt_version"]}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
