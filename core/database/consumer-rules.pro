# Consumer ProGuard rules for database module.
# Exposes Room entities and DAOs via api() - consumers need these rules.

# ROOM
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
-keep @androidx.room.Dao class *
-dontwarn androidx.room.paging.**
