# Database module ProGuard rules.
# For more details, see http://developer.android.com/guide/developing/tools/proguard.html

# -----------------------------------------------------------------------------
# ROOM
# -----------------------------------------------------------------------------

-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
-keep @androidx.room.Dao class *
-dontwarn androidx.room.paging.**

# -----------------------------------------------------------------------------
# PROJECT
# -----------------------------------------------------------------------------

-keep class com.huhx0015.androidbooster.database.** { *; }
