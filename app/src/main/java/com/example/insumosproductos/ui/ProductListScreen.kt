package com.example.insumosproductos.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ProductListScreen(
    productListViewModel: ProductListViewModel,
    onProductClick: (Int) -> Unit
) {
    val productListState = productListViewModel.listState
    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(horizontal = 24.dp),
        ) {
            item {
                Spacer(modifier = Modifier.height(64.dp + innerPadding.calculateTopPadding()))
                Text(
                    text = "Productos",
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = { productListViewModel.getProductList() },
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = MaterialTheme.shapes.large
                ) {
                    Text(
                        text = "Actualizar", style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier
                            .padding(8.dp),
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            if (productListState != null) items(productListState.data) { product ->
                Card(onClick = { onProductClick(product.id) }) {
                    Text(
                        text = product.name,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
            item {
                Spacer(modifier = Modifier.height(24.dp + innerPadding.calculateBottomPadding()))
            }
        }
    }
}