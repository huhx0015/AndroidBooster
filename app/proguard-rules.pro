# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in the SDK's proguard-android.txt.
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# -----------------------------------------------------------------------------
# GENERAL ANDROID
# -----------------------------------------------------------------------------

-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*,!method/inlining/*
-optimizationpasses 5
-allowaccessmodification
-dontpreverify

-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose

-keepattributes *Annotation*
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService

# For native methods, see http://proguard.sourceforge.net/manual/examples.html#native
-keepclasseswithmembernames class * {
    native <methods>;
}

# Keep setters in Views so that animations can still work
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}

# Keep methods in Activity that could be used in the XML attribute onClick
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

# For enumeration classes
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclassmembers class **.R$* {
    public static <fields>;
}

# Preserve line numbers for debugging stack traces
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception

# -----------------------------------------------------------------------------
# HILT / DAGGER
# -----------------------------------------------------------------------------

-keep class dagger.hilt.** { *; }
-keep class javax.inject.** { *; }
-keep class javax.annotation.** { *; }
-keep,allowobfuscation,allowshrinking @dagger.hilt.EntryPoint class *
-keep,allowobfuscation,allowshrinking @dagger.hilt.android.EarlyEntryPoint class *
-keep class *Hilt_* { *; }
-keep class *_HiltComponents* { *; }
-keep class *_MembersInjector { *; }
-keep class *_Factory { *; }

# -----------------------------------------------------------------------------
# ROOM
# -----------------------------------------------------------------------------

-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
-dontwarn androidx.room.paging.**

# -----------------------------------------------------------------------------
# RETROFIT
# -----------------------------------------------------------------------------

-keepattributes Signature
-keepattributes Exceptions
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}
-keep,allowobfuscation,allowshrinking interface retrofit2.Call
-keep,allowobfuscation,allowshrinking class retrofit2.Response
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn javax.annotation.**
-dontwarn kotlin.Unit
-dontwarn retrofit2.KotlinExtensions
-dontwarn retrofit2.KotlinExtensions$*

# -----------------------------------------------------------------------------
# OKHTTP
# -----------------------------------------------------------------------------

-dontwarn javax.annotation.**
-dontwarn org.codehaus.mojo.animal_sniffer.*
-dontwarn okhttp3.internal.platform.ConscryptPlatform
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

# -----------------------------------------------------------------------------
# GSON
# -----------------------------------------------------------------------------

-keepattributes Signature
-keepattributes *Annotation*
-dontwarn sun.misc.**
-keep class com.google.gson.stream.** { *; }
-keep class * extends com.google.gson.TypeAdapter
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

# -----------------------------------------------------------------------------
# MOSHI (if used)
# -----------------------------------------------------------------------------

-keepclassmembers class * {
    @com.squareup.moshi.FromJson <methods>;
    @com.squareup.moshi.ToJson <methods>;
}
-keep @com.squareup.moshi.JsonQualifier interface *
-keepclassmembers,allowobfuscation class * {
    @com.squareup.moshi.Json <fields>;
}

# -----------------------------------------------------------------------------
# RXJAVA
# -----------------------------------------------------------------------------

-dontwarn sun.misc.Unsafe
-dontwarn java.util.concurrent.atomic.*
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
   long producerIndex;
   long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

# -----------------------------------------------------------------------------
# KOTLIN
# -----------------------------------------------------------------------------

-keep class kotlin.** { *; }
-keep class kotlin.Metadata { *; }
-dontwarn kotlin.**
-keepclassmembers class **$WhenMappings {
    <fields>;
}
-keepclassmembers class kotlin.Metadata {
    public <methods>;
}
-assumenosideeffects class kotlin.jvm.internal.Intrinsics {
    static void checkParameterIsNotNull(java.lang.Object, java.lang.String);
}

# -----------------------------------------------------------------------------
# COROUTINES
# -----------------------------------------------------------------------------

-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}
-keepclassmembers class kotlinx.coroutines.** {
    volatile <fields>;
}
-dontwarn kotlinx.coroutines.**

# -----------------------------------------------------------------------------
# PROJECT SPECIFIC
# -----------------------------------------------------------------------------

# Keep network response/request model classes
-keep class com.huhx0015.androidbooster.network.** { *; }

# Keep data/entity classes consumed by app
-keep class com.huhx0015.androidbooster.** { *; }

# -----------------------------------------------------------------------------
# CRASHLYTICS (uncomment if using Firebase Crashlytics)
# -----------------------------------------------------------------------------

#-keep class com.crashlytics.** { *; }
#-dontwarn com.crashlytics.**
#-keepattributes *Annotation*
#-keepattributes SourceFile,LineNumberTable

# -----------------------------------------------------------------------------
# GOOGLE PLACES (uncomment if using)
# -----------------------------------------------------------------------------

#-keep class com.google.android.libraries.places.** { *; }
