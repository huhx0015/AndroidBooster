package com.huhx0015.androidbooster.base;

import android.content.Context;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import com.huhx0015.androidbooster.architecture.base.BaseActivity;
import com.huhx0015.androidbooster.network.RetrofitInterfaceTest;
import com.huhx0015.androidbooster.network.interfaces.RetrofitInterface;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import io.reactivex.schedulers.TestScheduler;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import okhttp3.mockwebserver.MockWebServer;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

@RunWith(AndroidJUnit4.class)
public class BaseNetworkTest {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // TEST VARIABLES
    private Context mContext;
    private TestScheduler mTestScheduler;

    // NETWORK VARIABLES
    private Retrofit mRetrofit;
    private RetrofitInterface mRetrofitInterface;

    // RULE VARIABLES
    @Rule
    public ActivityTestRule<BaseActivity> mActivityRule = new ActivityTestRule<>(BaseActivity.class);
    @Rule
    public MockWebServer mServer = new MockWebServer();

    /** INIT METHODS ___________________________________________________________________________ **/

    @Before
    public void setUp() {
        mContext = getInstrumentation().getTargetContext();
        mTestScheduler = new TestScheduler();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        mRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(mServer.url("/").toString())
                .client(client)
                .build();
        mRetrofitInterface = mRetrofit.create(RetrofitInterfaceTest.class);
    }
}