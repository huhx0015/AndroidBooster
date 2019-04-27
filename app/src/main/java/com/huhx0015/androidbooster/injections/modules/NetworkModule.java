package com.huhx0015.androidbooster.injections.modules;

import android.app.Application;
import androidx.annotation.NonNull;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huhx0015.androidbooster.network.interfaces.RetrofitInterface;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // CONSTANT VARIABLES:
    private static final int HTTP_CLIENT_CACHE = 10 * 1024 * 1024;

    // URL VARIABLES:
    private String mBaseUrl;

    /** CONSTRUCTOR METHODS ____________________________________________________________________ **/

    public NetworkModule(@NonNull String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    /** MODULE METHODS _________________________________________________________________________ **/

    @Provides
    @Singleton
    Cache providesCache(@NonNull Application application) {
        return new Cache(application.getCacheDir(), HTTP_CLIENT_CACHE);
    }

    @Provides
    @Singleton
    Gson providesGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(@NonNull Cache cache) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(@NonNull Gson gson, @NonNull OkHttpClient client) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mBaseUrl)
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    RetrofitInterface providesRetrofitInterface(@NonNull Retrofit retrofit) {
        return retrofit.create(RetrofitInterface.class);
    }
}