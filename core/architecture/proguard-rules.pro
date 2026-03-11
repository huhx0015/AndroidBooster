# Architecture module ProGuard rules.
# For more details, see http://developer.android.com/guide/developing/tools/proguard.html

# -----------------------------------------------------------------------------
# HILT
# -----------------------------------------------------------------------------

-keep class dagger.hilt.** { *; }
-keep class *Hilt_* { *; }

# -----------------------------------------------------------------------------
# LIFECYCLE / VIEWMODEL
# -----------------------------------------------------------------------------

-keep class * extends androidx.lifecycle.ViewModel {
    <init>(...);
}

# -----------------------------------------------------------------------------
# RXJAVA
# -----------------------------------------------------------------------------

-dontwarn sun.misc.Unsafe
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
   long producerIndex;
   long consumerIndex;
}

# -----------------------------------------------------------------------------
# PROJECT
# -----------------------------------------------------------------------------

-keep class com.huhx0015.androidbooster.architecture.** { *; }
