# Common module ProGuard rules.
# For more details, see http://developer.android.com/guide/developing/tools/proguard.html

# -----------------------------------------------------------------------------
# HILT
# -----------------------------------------------------------------------------

-keep class dagger.hilt.** { *; }
-keep class *Hilt_* { *; }

# -----------------------------------------------------------------------------
# GUAVA (exposed via api)
# -----------------------------------------------------------------------------

-dontwarn com.google.common.**
-dontwarn javax.annotation.**

# -----------------------------------------------------------------------------
# PROJECT
# -----------------------------------------------------------------------------

-keep class com.huhx0015.androidbooster.common.** { *; }
-keep class com.huhx0015.androidbooster.constants.** { *; }
