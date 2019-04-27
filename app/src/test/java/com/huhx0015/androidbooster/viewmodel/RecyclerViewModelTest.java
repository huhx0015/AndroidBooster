package com.huhx0015.androidbooster.viewmodel;

import com.huhx0015.androidbooster.application.AndroidApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class RecyclerViewModelTest {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // MOCK VARIABLES
    @Mock
    private ApiRecyclerViewModel mViewModel;
    @Mock
    private AndroidApplication mApplication;

    // TEST VARIABLES
    private static final String TEST_ERROR_TEXT = "An error occurred.";
    private static final String TEST_ERROR_TEXT_ALTERNATE = "An unknown error occurred.";

    /** INIT METHODS ___________________________________________________________________________ **/

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mApplication = mock(AndroidApplication.class);

        mViewModel = new ApiRecyclerViewModel(mApplication);
        mViewModel.setErrorText(TEST_ERROR_TEXT);
    }

    /** TEST METHODS ___________________________________________________________________________ **/

    @Test
    public void testGetErrorVisibility() throws Exception {
        Assert.assertFalse(mViewModel.getErrorVisible());
    }

    @Test
    public void testGetProgressBarVisibility() throws Exception {
        Assert.assertFalse(mViewModel.getProgressBarVisible());
    }

    @Test
    public void testGetRecyclerViewVisibility() throws Exception {
        Assert.assertFalse(mViewModel.getRecyclerViewVisible());
    }

    @Test
    public void testGetErrorText() throws Exception {
        Assert.assertEquals(TEST_ERROR_TEXT, mViewModel.getErrorText());
    }

    @Test
    public void testSetErrorVisibility() throws Exception {
        mViewModel.setErrorVisible(true);
        Assert.assertTrue(mViewModel.getErrorVisible());
    }

    @Test
    public void testSetProgressBarVisibility() throws Exception {
        mViewModel.setProgressBarVisible(true);
        Assert.assertTrue(mViewModel.getProgressBarVisible());
    }

    @Test
    public void testSetRecyclerViewVisibility() throws Exception {
        mViewModel.setRecyclerViewVisible(true);
        Assert.assertTrue(mViewModel.getRecyclerViewVisible());
    }

    @Test
    public void testSetErrorText() throws Exception {
        mViewModel.setErrorText(TEST_ERROR_TEXT_ALTERNATE);
        Assert.assertEquals(TEST_ERROR_TEXT_ALTERNATE, mViewModel.getErrorText());
    }
}