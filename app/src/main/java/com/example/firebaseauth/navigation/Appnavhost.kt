package com.example.firebaseauth.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firebaseauth.ui.theme.screens.about.Aboutscreen
import com.example.firebaseauth.ui.theme.screens.home.Homescreen
import com.example.firebaseauth.ui.theme.screens.login.Loginscreen
import com.example.firebaseauth.ui.theme.screens.product.AddProductsScreen
import com.example.firebaseauth.ui.theme.screens.product.UpdateProductsScreen
import com.example.firebaseauth.ui.theme.screens.product.ViewProductScreen
import com.example.firebaseauth.ui.theme.screens.register.Registerscreen

@Composable
fun AppNavHost(modifier: Modifier=Modifier, navController: NavHostController = rememberNavController(), startDestination: String= ROUT_LOGIN){
    NavHost(navController = navController,modifier=modifier, startDestination = startDestination) {
        composable(ROUT_HOME) {
            Homescreen(navController)
        }
        composable(ROUT_REGISTER){
            Registerscreen(navController)
        }
        composable(ROUT_ABOUT){
            Aboutscreen(navController)
        }
        composable(ROUT_LOGIN){
            Loginscreen(navController)
        }
        composable(ROUT_ADDPRODUCT){
            AddProductsScreen(navController)
        }
        composable(ROUT_UPDATEPRODUCT+"/{id}"){passedData->
            UpdateProductsScreen(navController,passedData.arguments?.getString("id")!!)
        }
        composable(ROUT_VIEWPRODUCT){
            ViewProductScreen(navController)
        }


    }
}
