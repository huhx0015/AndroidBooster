---
name: androidbooster-index
description: Master index for AndroidBooster project skills. Use when working in AndroidBooster to discover available architecture, audio, network, UI, and common patterns.
---

# AndroidBooster Project Skills

When working in this project, apply the following skills based on context:

| Skill | Use When |
|-------|----------|
| `androidbooster-architecture` | Creating activities, fragments, ViewModels; implementing MVI, MVVM, MVP, VIPER |
| `androidbooster-audio` | Music or sound playback; HXMusic, HXSound |
| `androidbooster-network` | API endpoints, Retrofit, network configuration |
| `androidbooster-common` | Constants, SharedPreferences, app-wide config |
| `androidbooster-ui` | List screens, image loading, dialogs, snackbars, display utils |
| `androidbooster-location` | Location services, LocationManager, LocationRequest |
| `androidbooster-localization` | Adding/changing strings.xml; propagating translations to locale directories |

## Module Structure

- `core/architecture` — MVI, MVVM, MVP, VIPER, base classes, DI
- `core/audio` — HX Audio Player (hxaudio-v331.aar)
- `core/network` — Retrofit, OkHttp, Gson
- `core/ui` — ApiRecyclerView, BindingUtils, DialogUtils, SnackbarUtils, DisplayUtils, UnitUtils
- `core/common` — AndroidConstants, ApplicationModule
- `core/location` — LocationModule
- `core/database` — (reserved)
