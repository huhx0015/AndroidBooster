# Consumer ProGuard rules for UI module.

# Keep View binding generated classes
-keep class * extends android.view.View {
    void set*(***);
    *** get*();
}
