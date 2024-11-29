package com.example.insumosproductos.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://192.168.0.56:3000"

private val json = Json {
    ignoreUnknownKeys = true // Ignores extra fields in the JSON response
    isLenient = true         // Allows for more relaxed JSON parsing
    encodeDefaults = true    // Encodes default values
}

private val retrofit =
    Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(
            BASE_URL
        )
        .build()

interface ApiService {
    @GET("productos/api")
    suspend fun getProductList(): ProductList

    @GET("productos/api/details")
    suspend fun getProductById(@Query("id") id: Int): Product?
}

object Api {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

@Serializable
data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val priceType: String,
    val profit: Double?,
    val link: String?,
    val image: String?
)

@Serializable
data class ProductList(
    val data: List<Product>,
    val total: Int,
    val nextCursor: Int
)
