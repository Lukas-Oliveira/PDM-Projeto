package com.example.conectatorcedor.ui

import android.content.Context
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.conectatorcedor.ui.nav.BottomNavItem

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun FavoritesPage(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
    context: Context
) {
    Text(text = "Tela de Favoritos")
}