package com.example.insumosproductos.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.insumosproductos.network.Api
import com.example.insumosproductos.network.Product
import kotlinx.coroutines.launch

class ProductDetailsViewModel(val productId: Int): ViewModel() {
    var productDetails by mutableStateOf<Product?>(null)

    fun getProductDetails() {
        viewModelScope.launch {
            productDetails = Api.retrofitService.getProductById(productId)
        }
    }

    init {
        getProductDetails()
    }
}