---
name: androidbooster-common
description: Common constants, DI modules, and shared utilities for AndroidBooster. Use when adding API constants, SharedPreferences, connectivity, or app-wide configuration.
---

# AndroidBooster Common

## Constants

`core/common/.../constants/AndroidConstants.kt`:

- `API_VERSION_1`, `CURRENT_API_VERSION` — API version strings
- `ANDROID_PREFERENCES` — SharedPreferences name
- `API_URL` — Base API URL

## ApplicationModule

`core/common/.../injections/ApplicationModule.kt` provides:

- `AssetManager`
- `ConnectivityManager`
- `SharedPreferences` (using `ANDROID_PREFERENCES`)

All are `@Singleton` and `@InstallIn(SingletonComponent::class)`.
