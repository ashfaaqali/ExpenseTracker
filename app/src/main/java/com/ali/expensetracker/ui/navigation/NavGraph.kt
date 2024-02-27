package com.ali.expensetracker.ui.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ali.expensetracker.ui.screens.PermissionScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String = Screen.TransactionList.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Permission.route) {
            PermissionScreen(onPermissionGranted = {
                navController.navigate(Screen.TransactionList.route)
            })
        }
        composable(route = Screen.TransactionList.route) {
            navController.popBackStack()
        }
        // Add more destinations as needed
    }
}
