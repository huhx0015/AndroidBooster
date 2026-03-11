# Consumer ProGuard rules for common module.
# Exposes Guava via api() - consumers need these rules.

# GUAVA
-dontwarn com.google.common.**
-dontwarn javax.annotation.**
