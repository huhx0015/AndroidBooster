package com.huhx0015.androidbooster.viewmodel

import android.app.Application
import androidx.databinding.PropertyChangeRegistry
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.mock

@RunWith(MockitoJUnitRunner::class)
class RecyclerViewModelTest {

    /** CONSTANTS _______________________________________________________________________________ */

    companion object {
        private const val TEST_ERROR_TEXT = "An error occurred."
        private const val TEST_ERROR_TEXT_ALTERNATE = "An unknown error occurred."
    }

    /** CLASS VARIABLES ________________________________________________________________________  */

    // MOCK VARIABLES
    @Mock
    lateinit var viewModel: ApiRecyclerViewModel
    @Mock
    lateinit var application: Application

    /** INIT METHODS ___________________________________________________________________________  */

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        application = mock(Application::class.java)

        viewModel = ApiRecyclerViewModel(application)
        // Manually initialize Hilt-injected dependencies for testing
        viewModel.disposable = CompositeDisposable()
        viewModel.registry = PropertyChangeRegistry()
        viewModel.errorText = TEST_ERROR_TEXT
    }

    /** TEST METHODS ___________________________________________________________________________  */

    @Test
    fun testGetErrorVisibility() {
        Assert.assertFalse(viewModel.errorVisible)
    }

    @Test
    fun testGetProgressBarVisibility() {
        Assert.assertFalse(viewModel.progressBarVisible)
    }

    @Test
    fun testGetRecyclerViewVisibility() {
        Assert.assertFalse(viewModel.recyclerViewVisible)
    }

    @Test
    fun testGetErrorText() {
        Assert.assertEquals(TEST_ERROR_TEXT, viewModel.errorText)
    }

    @Test
    fun testSetErrorVisibility() {
        viewModel.errorVisible = true
        Assert.assertTrue(viewModel.errorVisible)
    }

    @Test
    fun testSetProgressBarVisibility() {
        viewModel.progressBarVisible = true
        Assert.assertTrue(viewModel.progressBarVisible)
    }

    @Test
    fun testSetRecyclerViewVisibility() {
        viewModel.recyclerViewVisible = true
        Assert.assertTrue(viewModel.recyclerViewVisible)
    }

    @Test
    fun testSetErrorText() {
        viewModel.errorText = TEST_ERROR_TEXT_ALTERNATE
        Assert.assertEquals(TEST_ERROR_TEXT_ALTERNATE, viewModel.errorText)
    }
}