package com.example.conectatorcedor.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    var title: String,
    var icon: ImageVector,
    var route: String
) {
    data object FavoritesPage: BottomNavItem("Alertas Próximos", Icons.Outlined.Warning, "alertas proximos")
    data object HomePage: BottomNavItem("Inicio", Icons.Outlined.Home, "home")
    data object ProfilePage: BottomNavItem("Perfil", Icons.Outlined.AccountCircle, "perfil")
}