package com.ali.expensetracker.ui.navigation

sealed class Screen(val route: String) {
    object Permission : Screen(route = "permissionScreen")
    object TransactionList : Screen(route = "transactionListScreen")
    object AddTransaction : Screen(route = "addTransactionScreen")
}
