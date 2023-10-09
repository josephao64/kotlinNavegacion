package com.example.navegacioncompose.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navegacioncompose.Views.DetailView
import com.example.navegacioncompose.Views.HomeView


@Composable
fun NavManager() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeView(navController)
        }
        composable(
            route = "Detail/{id}?opcional={opcional}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                },
                navArgument("opcional") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            val opcional = backStackEntry.arguments?.getString("opcional") ?: ""
            DetailView(navController, id, opcional)
        }
    }
}
