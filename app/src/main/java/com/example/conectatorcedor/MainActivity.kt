package com.example.conectatorcedor

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.conectatorcedor.ui.MainViewModel
import com.example.conectatorcedor.ui.nav.BottomNavBar
import com.example.conectatorcedor.ui.nav.BottomNavItem
import com.example.conectatorcedor.ui.nav.MainNavHost
import com.example.conectatorcedor.ui.theme.ConectaTorcedorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()

        setContent {

            val navController = rememberNavController()
            val context = LocalContext.current
            val currentRoute = navController.currentBackStackEntryAsState()
            val showButton = currentRoute.value?.destination?.route == BottomNavItem.HomePage.route

            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.RequestPermission(),
                onResult = {}
            )

            var activity = LocalContext.current as? Activity

            ConectaTorcedorTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavBar(navController = navController)
                    },
                    floatingActionButton = {
                        if (showButton) {
                            FloatingActionButton(
                                onClick = {
                                    activity?.startActivity(
                                        Intent(activity, IssueAlertActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                                    )
                                },
                            ) {
                                Icon(imageVector = Icons.Default.Add, contentDescription = "Adicionar")
                            }
                        }
                    },
                    floatingActionButtonPosition = FabPosition.Start,
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {

                        launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)

                        MainNavHost(
                            navController = navController,
                            viewModel = viewModel,
                            context = context
                        )
                    }
                }
            }
        }
    }
}
