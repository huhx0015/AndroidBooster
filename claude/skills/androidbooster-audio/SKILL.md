---
name: androidbooster-audio
description: HX Audio Player for music and sound playback. Use when implementing music playback, sound effects, HXMusic, HXSound, or audio in AndroidBooster. Uses hxaudio-v331.aar in core/audio.
---

# AndroidBooster Audio (HX Audio Player)

Use HX Audio Player for music and sound in AndroidBooster. The library is in `core/audio` (hxaudio-v331.aar). Supports Android 2.3+ with workarounds for MediaPlayer/SoundPool bugs.

**Audio files:** Place audio files in the `res/raw/` folder (e.g. `res/raw/my_song.mp3` → `R.raw.my_song`).

## Music Playback (HXMusic)

**Play from resource:**
```kotlin
HXMusic.music()
    .load(R.raw.my_song_name)    // [REQUIRED]
    .title("My Awesome Song")    // [OPTIONAL]
    .artist("Mr. Anonymous")    // [OPTIONAL]
    .date("January 1, 1998")    // [OPTIONAL]
    .at(5)                      // Start position (seconds)
    .gapless(true)              // Gapless playback
    .looped(true)               // Loop
    .play(this)                 // [REQUIRED]
```

**Play from path/URL:**
```kotlin
HXMusic.music()
    .load("http://example.com/song.mp3")
    .title("My Awesome Song")
    .play(this)
```

**Control:**
- `HXMusic.pause()` — Pause
- `HXMusic.resume(this)` — Resume
- `HXMusic.stop()` — Stop all
- `HXMusic.isPlaying()` — Boolean
- `HXMusic.getPosition()` / `HXMusic.setPosition(0)` — Position
- `HXMusic.setListener(this)` — HXMusicListener
- `HXMusic.getStatus()` — Status string
- `HXMusic.enable(true)` — Enable/disable
- `HXMusic.logging(true)` — Log output
- `HXMusic.clear()` — Clear when app is terminating

**Lifecycle (Activity/Fragment):** When pausing music on background and resuming on foreground:

- `onPause()` → `HXMusic.pause()` — Pause when app is backgrounded
- `onResume()` → `HXMusic.resume(this)` — Resume when activity/fragment is in foreground
- App terminating → `HXMusic.clear()` — Clean up when the app is shutting down

## Sound Playback (HXSound)

**Play sound:**
```kotlin
HXSound.sound()
    .load(R.raw.my_sound_effect)  // [REQUIRED]
    .looped(true)                 // [OPTIONAL]
    .play(this)                   // [REQUIRED]
```

**Control:**
- `HXSound.pause()` — Pause looping sounds
- `HXSound.resume()` — Resume
- `HXSound.load()` — Pre-load resources
- `HXSound.engines(2)` — Multiple sound engines (API 9–10)
- `HXSound.enable(true)` — Enable/disable
- `HXSound.reinitialize(this)` — Re-init (API 9–10)
- `HXSound.logging(true)` — Log output
- `HXSound.clear()` — Clear when no longer needed

## Module

Add `core:audio` dependency. Audio is provided via `hxaudio-v331.aar` in the audio module.
