package com.omeriyioz.data.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.omeriyioz.data.BuildConfig
import com.omeriyioz.data.network.MarvelApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigInteger
import java.security.MessageDigest
import javax.inject.Singleton

private const val BASE_URL = "https://gateway.marvel.com:443/"

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor { chain ->
                val original = chain.request()
                val url = original.url
                    .newBuilder()
                    .build()
                val request = original
                    .newBuilder()
                    .url(url)
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(
                ChuckerInterceptor.Builder(context)
                    .collector(ChuckerCollector(context))
                    .maxContentLength(250000L)
                    .redactHeaders(emptySet())
                    .alwaysReadResponseBody(false)
                    .build()
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {

        return Retrofit.Builder()
            //.addConverterFactory(MoshiConverterFactory.create(moshi))
            .addConverterFactory(GsonConverterFactory.create())
            // .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideRestInterface(retrofit: Retrofit): MarvelApiService {
        return retrofit.create(MarvelApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    companion object {
        private val authInterceptor = { chain: Interceptor.Chain ->
            val ts = System.currentTimeMillis()

            val hash =
                "$ts${BuildConfig.MARVEL_PRIVATE_API_KEY}${BuildConfig.MARVEL_PUBLIC_API_KEY}".md5()
            val request = chain.request()
            val url = request.url
                .newBuilder()
                .addQueryParameter("ts", ts.toString())
                .addQueryParameter("apikey", BuildConfig.MARVEL_PUBLIC_API_KEY)
                .addQueryParameter("hash", hash)
                .build()
            val updated = request.newBuilder()
                .url(url)
                .build()

            chain.proceed(updated)
        }
    }
}

fun String.md5(): String =
    BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
        .toString(16).padStart(32, '0')
