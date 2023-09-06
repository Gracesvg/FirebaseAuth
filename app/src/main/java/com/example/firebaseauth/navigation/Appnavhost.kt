package com.example.firebaseauth.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firebaseauth.ui.theme.screens.login.Loginscreen
import com.example.firebaseauth.ui.theme.screens.register.Registerscreen

@Composable
fun AppNavHost(modifier: Modifier=Modifier, navController: NavHostController = rememberNavController(), startDestination: String= ROUT_LOGIN){
    NavHost(navController = navController,modifier=modifier, startDestination = startDestination) {
        composable(ROUT_LOGIN) {
            Loginscreen(navController)
        }
        composable(ROUT_REGISTER){
            Registerscreen(navController)
        }
        }
    }
