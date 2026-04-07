package com.huhx0015.androidbooster.ui.activities.composedata

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.huhx0015.androidbooster.architecture.base.BaseActivity

class ComposeDataActivity : BaseActivity() {

    private val viewModel: ComposeDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initCompose()
    }

    private fun initCompose() {
        setContent {
            val state by viewModel.state.collectAsState()
            val snackbarHostState = remember { SnackbarHostState() }

            LaunchedEffect(viewModel) {
                viewModel.events.collect { event ->
                    when (event) {
                        is ComposeDataEvent.ShowMessage -> {
                            snackbarHostState.showSnackbar(event.message)
                        }
                    }
                }
            }

            Scaffold(
                snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
            ) { innerPadding ->
                ComposeDataScreen(
                    state = state,
                    onIntent = viewModel::sendIntent,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}