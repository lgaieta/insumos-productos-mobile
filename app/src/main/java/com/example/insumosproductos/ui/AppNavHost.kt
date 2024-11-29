package com.example.insumosproductos.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

enum class AppScreen {
    ProductList,
    ProductDetails,
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = AppScreen.ProductList.name
    ) {
        composable(route = AppScreen.ProductList.name) {
            val productListViewModel = ProductListViewModel()
            ProductListScreen(
                productListViewModel,
                onProductClick = { id -> navController.navigate("${AppScreen.ProductDetails.name}/$id") }
            )
        }
        composable(
            route = "${AppScreen.ProductDetails.name}/{id}", arguments = listOf(
                navArgument("id") {
                    type = androidx.navigation.NavType.IntType
                })
        ) { navBackStackEntry ->
            val productId = navBackStackEntry.arguments?.getInt("id")
            if (productId == null) navController.navigate(AppScreen.ProductList.name)
            else {
                val productDetailsViewModel = ProductDetailsViewModel(productId)
                ProductDetailsScreen(productDetailsViewModel)
            }
        }
    }
}