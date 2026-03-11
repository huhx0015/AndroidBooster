# Audio module ProGuard rules.
# For more details, see http://developer.android.com/guide/developing/tools/proguard.html

# -----------------------------------------------------------------------------
# NATIVE / AAR
# -----------------------------------------------------------------------------

-keepclasseswithmembernames class * {
    native <methods>;
}

# -----------------------------------------------------------------------------
# PROJECT
# -----------------------------------------------------------------------------

-keep class com.huhx0015.androidbooster.audio.** { *; }
