# Location module ProGuard rules.
# For more details, see http://developer.android.com/guide/developing/tools/proguard.html

# -----------------------------------------------------------------------------
# HILT
# -----------------------------------------------------------------------------

-keep class *Hilt_* { *; }

# -----------------------------------------------------------------------------
# GOOGLE PLAY SERVICES LOCATION
# -----------------------------------------------------------------------------

-keep class com.google.android.gms.location.** { *; }
-dontwarn com.google.android.gms.**

# -----------------------------------------------------------------------------
# PROJECT
# -----------------------------------------------------------------------------

-keep class com.huhx0015.androidbooster.location.** { *; }
