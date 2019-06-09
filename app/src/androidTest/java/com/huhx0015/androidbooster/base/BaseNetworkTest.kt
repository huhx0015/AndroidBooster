package com.huhx0015.androidbooster.base

import android.content.Context
import androidx.test.rule.ActivityTestRule
import com.huhx0015.androidbooster.architecture.base.BaseActivity
import com.huhx0015.androidbooster.network.RetrofitInterfaceTest
import com.huhx0015.androidbooster.network.interfaces.RetrofitInterface
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import io.reactivex.schedulers.TestScheduler
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.mockwebserver.MockWebServer
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.runner.AndroidJUnit4

@RunWith(AndroidJUnit4::class)
class BaseNetworkTest {

    /** CLASS VARIABLES ________________________________________________________________________  */

    // TEST VARIABLES
    private var mContext: Context? = null
    private var mTestScheduler: TestScheduler? = null

    // NETWORK VARIABLES
    private var mRetrofit: Retrofit? = null
    private var mRetrofitInterface: RetrofitInterface? = null

    // RULE VARIABLES
    @Rule
    var mActivityRule = ActivityTestRule(BaseActivity::class.java)
    @Rule
    var mServer = MockWebServer()

    /** INIT METHODS ___________________________________________________________________________  */

    @Before
    fun setUp() {
        mContext = getInstrumentation().targetContext
        mTestScheduler = TestScheduler()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

        mRetrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(mServer.url("/").toString())
                .client(client)
                .build()
        mRetrofitInterface = mRetrofit!!.create(RetrofitInterfaceTest::class.java)
    }
}