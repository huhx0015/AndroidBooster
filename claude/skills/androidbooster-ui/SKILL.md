---
name: androidbooster-ui
description: UI components and utilities for AndroidBooster. Use when building list screens, image loading, dialogs, snackbars, or display/unit conversions.
---

# AndroidBooster UI

## List Screens

- `ApiRecyclerViewActivity` — Activity for API-backed RecyclerView; injects `ApiRecyclerViewModel`, `Retrofit`
- `ApiRecyclerViewFragment` — Fragment variant
- `ApiRecyclerViewModel` — Extends `BaseViewModel`; exposes `errorText`, `errorVisible`, `progressBarVisible`, `recyclerViewVisible` with DataBinding

## BindingUtils

`core/ui/.../utils/BindingUtils.kt`:
- `@BindingAdapter("app:imageUrl")` — Load image URL into `ImageView` via Coil; uses `ic_image_placeholder` on error

## SnackbarUtils

`core/ui/.../utils/SnackbarUtils.kt`:
- `displaySnackbar(parentView, message, length, color)`
- `displaySnackbarWithAction(parentView, message, length, color, actionText, listener)`

## DialogUtils

`core/ui/.../utils/DialogUtils.kt`:
- `displayAlertDialog(context, title, message)` — Simple alert
- `createProgressDialog(context)` — Progress dialog with `dialog_progress` layout

## DisplayUtils

`core/ui/.../utils/DisplayUtils.kt`:
- `getOrientation(context)` — Returns `Configuration.ORIENTATION_PORTRAIT` or `ORIENTATION_LANDSCAPE`

## UnitUtils

`core/ui/.../utils/UnitUtils.kt`:
- `convertDpToPixels(context, dp)` — dp → px
- `convertPixelsToDp(context, px)` — px → dp
