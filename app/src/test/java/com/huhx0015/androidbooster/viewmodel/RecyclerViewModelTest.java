package com.huhx0015.androidbooster.viewmodel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by Michael Yoon Huh on 6/22/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class RecyclerViewModelTest {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // MOCK VARIABLES
    @Mock private RecyclerViewModel mViewModel;

    // TEST VARIABLES
    private static final String TEST_ERROR_TEXT = "An error occurred.";
    private static final String TEST_ERROR_TEXT_ALTERNATE = "An unknown error occurred.";

    /** INIT METHODS ___________________________________________________________________________ **/

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mViewModel = new RecyclerViewModel();
        mViewModel.setErrorText(TEST_ERROR_TEXT);
    }

    /** TEST METHODS ___________________________________________________________________________ **/

    @Test
    public void testGetErrorVisibility() throws Exception {
        Assert.assertEquals(false, mViewModel.getErrorVisible());
    }

    @Test
    public void testGetProgressBarVisibility() throws Exception {
        Assert.assertEquals(false, mViewModel.getProgressBarVisible());
    }

    @Test
    public void testGetRecyclerViewVisibility() throws Exception {
        Assert.assertEquals(false, mViewModel.getRecyclerViewVisible());
    }

    @Test
    public void testGetErrorText() throws Exception {
        Assert.assertEquals(TEST_ERROR_TEXT, mViewModel.getErrorText());
    }

    @Test
    public void testSetErrorVisibility() throws Exception {
        mViewModel.setErrorVisible(true);
        Assert.assertEquals(true, mViewModel.getErrorVisible());
    }

    @Test
    public void testSetProgressBarVisibility() throws Exception {
        mViewModel.setProgressBarVisible(true);
        Assert.assertEquals(true, mViewModel.getProgressBarVisible());
    }

    @Test
    public void testSetRecyclerViewVisibility() throws Exception {
        mViewModel.setRecyclerViewVisible(true);
        Assert.assertEquals(true, mViewModel.getRecyclerViewVisible());
    }

    @Test
    public void testSetErrorText() throws Exception {
        mViewModel.setErrorText(TEST_ERROR_TEXT_ALTERNATE);
        Assert.assertEquals(TEST_ERROR_TEXT_ALTERNATE, mViewModel.getErrorText());
    }
}