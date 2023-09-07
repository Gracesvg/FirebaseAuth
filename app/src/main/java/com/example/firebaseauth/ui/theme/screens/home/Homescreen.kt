package com.example.firebaseauth.ui.theme.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firebaseauth.navigation.ROUT_ADDPRODUCT
import com.example.firebaseauth.navigation.ROUT_VIEWPRODUCT
import productviewmodel


@Composable
fun Homescreen(navController: NavHostController){
    val context = LocalContext.current
    var productdata=productviewmodel(navController,context)


    Column (modifier= Modifier
        .fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Welcome to Homepage",
            color= Color.White,
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace)
        Spacer(modifier = Modifier.height(100.dp))

        Button( onClick = {
            navController.navigate(ROUT_ADDPRODUCT) }
            ,Modifier.fillMaxWidth()){
            Text(text = "Add Product",
                color= Color.Black,
                fontSize = 30.sp,
                fontFamily = FontFamily.Monospace)}
        Spacer(modifier = Modifier.height(100.dp))


        Button( onClick = {
            navController.navigate(ROUT_VIEWPRODUCT) }
            ,Modifier.fillMaxWidth()){
            Text(text = "View Product",
                    color= Color.Black,
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Monospace)}
            }
    }


@Preview
@Composable

fun Homepreview(){
    Homescreen(rememberNavController() )
}