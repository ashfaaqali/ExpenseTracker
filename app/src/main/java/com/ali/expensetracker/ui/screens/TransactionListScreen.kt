package com.ali.expensetracker.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun TransactionListScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(1f),
        color = MaterialTheme.colorScheme.background)
    {
        Text(text = "Expenses List.", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
    }
}