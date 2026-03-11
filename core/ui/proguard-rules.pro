# UI module ProGuard rules.
# For more details, see http://developer.android.com/guide/developing/tools/proguard.html

# -----------------------------------------------------------------------------
# VIEW BINDING / DATA BINDING
# -----------------------------------------------------------------------------

-keep class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers class * extends android.view.View {
    void set*(***);
    *** get*();
}

# -----------------------------------------------------------------------------
# PARCELABLE
# -----------------------------------------------------------------------------

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

# -----------------------------------------------------------------------------
# PROJECT
# -----------------------------------------------------------------------------

-keep class com.huhx0015.androidbooster.ui.** { *; }
