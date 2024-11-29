package com.example.insumosproductos.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ProductDetailsScreen(productDetailsViewModel: ProductDetailsViewModel) {
    val product = productDetailsViewModel.productDetails

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier.padding(horizontal = 24.dp),
        ) {
            Spacer(modifier = Modifier.height(64.dp + innerPadding.calculateTopPadding()))
            Text(text = product?.name ?: "", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "$${product?.price.toString()}",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}