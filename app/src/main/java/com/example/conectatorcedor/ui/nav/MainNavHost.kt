package com.example.conectatorcedor.ui.nav

import android.content.Context
import android.provider.ContactsContract.Profile
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.conectatorcedor.ui.FavoritesPage
import com.example.conectatorcedor.ui.HomePage
import com.example.conectatorcedor.ui.MainViewModel
import com.example.conectatorcedor.ui.ProfilePage

@Composable
fun MainNavHost(
    navController: NavHostController,
    viewModel: MainViewModel,
    context: Context
) {
    NavHost(navController, startDestination = BottomNavItem.HomePage.route) {
        composable(route = BottomNavItem.FavoritesPage.route) {
            FavoritesPage(viewModel = viewModel, context = context)
        }
        composable(route = BottomNavItem.HomePage.route) {
            HomePage(viewModel = viewModel, context = context)
        }
        composable(route = BottomNavItem.ProfilePage.route) {
            ProfilePage(viewModel = viewModel, context = context)
        }
    }
}
