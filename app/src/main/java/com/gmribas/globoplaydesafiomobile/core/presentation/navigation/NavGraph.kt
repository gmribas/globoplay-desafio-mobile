package com.gmribas.globoplaydesafiomobile.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gmribas.globoplaydesafiomobile.feature.details.presentation.DetailsScreen
import com.gmribas.globoplaydesafiomobile.feature.home.presentation.HomeScreen
import com.gmribas.globoplaydesafiomobile.feature.mylist.presentation.MyListScreen

@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    )
    {
        composable(Screens.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(
            Screens.Details.route + "/{id}/{isTvShow}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType },
                navArgument("isTvShow") {
                    type = NavType.BoolType
                    defaultValue = false
                }
            )
        ) {
            DetailsScreen(navController)
        }

        composable(Screens.MyList.route) {
            MyListScreen(navController = navController)
        }
    }
}