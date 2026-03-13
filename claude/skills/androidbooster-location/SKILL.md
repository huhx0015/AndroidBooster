---
name: androidbooster-location
description: Location services for AndroidBooster. Use when implementing location tracking, LocationManager, or LocationRequest in services.
---

# AndroidBooster Location

## LocationModule

`core/location/.../modules/LocationModule.kt` — `@InstallIn(ServiceComponent::class)`:

- `LocationManager` — System location service
- `LocationRequest` — `PRIORITY_BALANCED_POWER_ACCURACY`, 10s update interval, 5s fastest interval

Both are `@ServiceScoped`. Use in Hilt-injected services that need location.
