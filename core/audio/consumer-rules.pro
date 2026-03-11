# Consumer ProGuard rules for audio module.
# Local AAR (hxaudio) - keep native methods.

-keepclasseswithmembernames class * {
    native <methods>;
}
