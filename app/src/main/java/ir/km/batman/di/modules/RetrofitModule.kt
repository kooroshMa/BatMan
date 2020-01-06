package ir.km.batman.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import ir.km.batman.ApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * okhttp and interceptor will be added later
 **/

@Module
object RetrofitModule {

    private const val BASE_URL = "http://www.omdbapi.com"



    @Reusable
    @Provides
    fun provideApiService(retrofit: Retrofit):ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Reusable
    @Provides
    fun providerRetrofit(gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Reusable
    @Provides
    fun providerGsonConvertFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Reusable
    @Provides
    fun provideGson() = GsonBuilder().create()
}