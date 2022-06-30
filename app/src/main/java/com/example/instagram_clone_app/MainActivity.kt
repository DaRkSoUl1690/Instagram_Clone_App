package com.example.instagram_clone_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instagram_clone_app.screen.FeedsScreen
import com.example.instagram_clone_app.screen.SearchScreen
import com.example.instagram_clone_app.screen.SplashScreen
import com.example.instagram_clone_app.screen.authentication.AuthenticationViewModel
import com.example.instagram_clone_app.screen.authentication.LoginScreen
import com.example.instagram_clone_app.screen.authentication.SignUpScreen
import com.example.instagram_clone_app.screen.profile.ProfileScreen
import com.example.instagram_clone_app.ui.theme.Instagram_Clone_AppTheme
import com.example.instagram_clone_app.utils.Screens
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Instagram_Clone_AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val authViewModel: AuthenticationViewModel = hiltViewModel()
                    InstagramCloneApp(navController, authenticationViewModel = authViewModel)
                }
            }
        }
    }
}

@Composable
fun InstagramCloneApp(
    navController: NavHostController,
    authenticationViewModel: AuthenticationViewModel
) {
    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(route = Screens.LoginScreen.route) {
            LoginScreen(navController = navController, authViewModel = authenticationViewModel)
        }
        composable(route = Screens.SignUpScreen.route) {
            SignUpScreen()
        }
        composable(route = Screens.SplashScreen.route) {
            SplashScreen(navController = navController, authViewModel = authenticationViewModel)
        }
        composable(route = Screens.FeedsScreen.route) {
            FeedsScreen()
        }
        composable(route = Screens.ProfileScreen.route) {
            ProfileScreen()
        }
        composable(route = Screens.SearchScreen.route) {
            SearchScreen()
        }
    }
}
