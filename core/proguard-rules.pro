# Core module ProGuard rules.
# For more details, see http://developer.android.com/guide/developing/tools/proguard.html

# -----------------------------------------------------------------------------
# GENERAL
# -----------------------------------------------------------------------------

-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclassmembers class **.R$* {
    public static <fields>;
}
