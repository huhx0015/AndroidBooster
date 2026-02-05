package com.huhx0015.androidbooster.architecture.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<S : BaseState, I : BaseIntent, E : BaseEvent> : ViewModel() {
  abstract val state: StateFlow<S>
  abstract val events: Flow<E>

  private val intentChannel = Channel<I>(Channel.UNLIMITED)


  init {
    viewModelScope.launch {
      intentChannel.consumeAsFlow()
        .collect { intent -> processIntent(intent) }
    }
  }

  protected abstract suspend fun processIntent(intent: I)

  fun sendIntent(intent: I) {
    viewModelScope.launch { intentChannel.send(intent) }
  }
}