# Consumer ProGuard rules for architecture module.

# HILT
-keep class *Hilt_* { *; }

# VIEWMODEL
-keep class * extends androidx.lifecycle.ViewModel {
    <init>(...);
}
