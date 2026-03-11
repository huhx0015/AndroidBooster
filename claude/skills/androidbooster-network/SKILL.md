---
name: androidbooster-network
description: Network and Retrofit setup for AndroidBooster. Use when adding API endpoints, Retrofit interfaces, or configuring network layer. Uses Retrofit, OkHttp, Gson.
---

# AndroidBooster Network

## Retrofit Interface

Define API endpoints in `core/network/src/main/kotlin/com/huhx0015/androidbooster/network/interfaces/RetrofitInterface.kt`. Extend or use this interface for your API calls.

## NetworkModule

`core/network/.../injections/NetworkModule.kt` provides:

- `Retrofit` with base URL from `AndroidConstants.API_URL`
- `Gson` with `LOWER_CASE_WITH_UNDERSCORES` field naming
- `OkHttpClient` with cache (10MB) and `HttpLoggingInterceptor` (BODY)
- `RetrofitInterface` via `retrofit.create(RetrofitInterface::class.java)`

## Base URL

Configure in `core/common/.../constants/AndroidConstants.kt`:
- `API_URL` — Base URL for Retrofit
- `API_VERSION_1`, `CURRENT_API_VERSION` — Version constants

## Usage

Inject `Retrofit` or `RetrofitInterface` in activities/fragments/ViewModels. Add endpoint methods to `RetrofitInterface` (or create interfaces and obtain via `retrofit.create()`).
