---
name: androidbooster-architecture
description: Defines architecture patterns for AndroidBooster. Use when implementing MVI, MVVM, VIPER, MVP, or base UI components. Use when creating activities, fragments, ViewModels, or structuring feature modules.
---

# AndroidBooster Architecture

Use the architecture base classes from `core/architecture/src/main/kotlin/com/huhx0015/androidbooster/architecture/` when building features.

## Base Classes (Always Use)

Extend these for all activities, fragments, and ViewModels:

| Class | Path | Usage |
|-------|------|-------|
| `BaseActivity` | `architecture/base/BaseActivity.kt` | Extend `AppCompatActivity`; includes Hilt `@AndroidEntryPoint`, `CompositeDisposable` |
| `BaseFragment` | `architecture/base/BaseFragment.kt` | Extend `Fragment`; includes Hilt `@AndroidEntryPoint` |
| `BaseViewModel` | `architecture/base/BaseViewModel.kt` | Extend `AndroidViewModel`; includes DataBinding `Observable`, `CompositeDisposable`, lifecycle callbacks |

## MVI Architecture

Use `architecture/mvi/` when implementing Model-View-Intent:

| Class | Purpose |
|-------|---------|
| `BaseContract` | Defines `View : BaseView` |
| `BaseView` | `initView()`, `observe()` |
| `BaseViewModel<S, I, E>` | `state: StateFlow<S>`, `events: Flow<E>`, `sendIntent(I)` |
| `BaseState` | State object observed by View via `StateFlow` |
| `BaseIntent` | Intents sent from View → ViewModel |
| `BaseEvent` | Events sent from ViewModel → View |

**Flow:** View sends intents via `sendIntent()` → ViewModel processes in `processIntent()` → ViewModel updates `state` and emits `events` → View observes `state` and handles `events`.

## MVVM Architecture

Use `architecture/mvvm/` when implementing Model-View-ViewModel:

| Class | Purpose |
|-------|---------|
| `BaseContract` | Defines `View : BaseView`, `ViewModel : BaseViewModel<View>` |
| `BaseView` | `initView()` |
| `BaseViewModel<V>` | ViewModel bound to View |

## MVP Architecture

Use `architecture/mvp/` when implementing Model-View-Presenter:

| Class | Purpose |
|-------|---------|
| `BaseContract` | Defines `View : BaseView<Presenter>`, `Presenter : BasePresenter`, `Repository` |
| `BaseView<P>` | View with presenter reference |
| `BasePresenter` | Presenter interface |

Reference: https://www.codeproject.com/Articles/1098822/Learn-Android-MVP-Pattern-By-Example

## VIPER Architecture

Use `architecture/viper/` when implementing VIPER:

| Class | Purpose |
|-------|---------|
| `BaseContract` | Defines `View`, `Interactor`, `InteractorOutput`, `Presenter`, `Entity`, `Router` |

Reference: https://cheesecakelabs.com/blog/using-viper-architecture-android/

## Event Bus

Use `architecture/event/RxBus.kt` for cross-component event communication.

## Dependency Injection

Hilt modules in `architecture/modules/`:

- `ActivityModule`, `FragmentModule`, `ViewModelModule`, `RxBusModule`

## UI Components

- `ApiRecyclerViewModel` (extends `BaseViewModel`) for list screens with error/progress visibility
- `ApiRecyclerViewActivity`, `ApiRecyclerViewFragment` for API-backed RecyclerView screens
