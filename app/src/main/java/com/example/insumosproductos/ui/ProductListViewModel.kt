package com.example.insumosproductos.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.insumosproductos.network.Api
import com.example.insumosproductos.network.ProductList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ProductListViewModel : ViewModel() {
    var listState by mutableStateOf<ProductList?>(null)

    fun getProductList() {
        viewModelScope.launch {
            val result = Api.retrofitService.getProductList()
            listState = result
        }
    }

    init {
        getProductList()
    }
}