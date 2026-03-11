# Consumer ProGuard rules for network module.
# Exposes Retrofit, OkHttp, Gson via api() - consumers need these rules.

# RETROFIT
-keepattributes Signature
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}
-keep interface com.huhx0015.androidbooster.network.interfaces.** { *; }

# OKHTTP
-dontwarn javax.annotation.**
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

# GSON
-keepattributes Signature
-keepattributes *Annotation*
