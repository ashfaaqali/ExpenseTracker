package com.ali.expensetracker

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ali.expensetracker.ui.navigation.Screen
import com.ali.expensetracker.ui.navigation.SetupNavGraph
import com.ali.expensetracker.ui.screens.PermissionGranted
import com.ali.expensetracker.ui.theme.ExpenseTrackerTheme
import com.ali.expensetracker.ui.screens.PermissionScreen
import com.ali.expensetracker.ui.screens.TransactionListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(applicationContext)
        }
    }
}

@Composable
fun App(context: Context) {
    val navController = rememberNavController()
    SetupNavGraph(navController = navController)

    val permission = Manifest.permission.RECEIVE_SMS
    val permissionCheckResult = ContextCompat.checkSelfPermission(context, permission)
    if (permissionCheckResult != PackageManager.PERMISSION_GRANTED) {
        Toast.makeText(context, "Permission Not Granted.", Toast.LENGTH_SHORT).show()
        PermissionScreen {
            Toast.makeText(context, "Permission Granted.", Toast.LENGTH_SHORT).show()
            navController.navigate(Screen.Permission.route)
        }
    } else {
        Toast.makeText(context, "Permission Granted.", Toast.LENGTH_SHORT).show()
    }
}