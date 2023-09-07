package com.example.firebaseauth.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.firebaseauth.navigation.ROUT_HOME
import com.example.firebaseauth.navigation.ROUT_LOGIN
import com.google.firebase.auth.FirebaseAuth

class Authviewmodel(var navController:NavHostController, var context:Context){

    var mAuth:FirebaseAuth

    init {
        mAuth= FirebaseAuth.getInstance()
    }
    fun signup(email:String,pass:String,confpass:String){

        if (email.isBlank() || pass.isBlank() ||confpass.isBlank()){
            Toast.makeText(context,"Please email and password cannot be blank",Toast.LENGTH_LONG).show()
            return
        }else if (pass != confpass){
            Toast.makeText(context,"Password do not match",Toast.LENGTH_LONG).show()
            return
        }else{
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(context,"Registered Successfully",Toast.LENGTH_LONG).show()
                    navController.navigate(ROUT_HOME)

                }else{
                    Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                    navController.navigate(ROUT_LOGIN)
                }
            }
        }

    }
    fun login(email: String,pass: String){

        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(context,"Succeffully Logged in",Toast.LENGTH_LONG).show()
                navController.navigate(ROUT_HOME)
//                navController.navigate(ROUTE_REGISTER)TO TAKE YOU TO A DIIFFERNT PAGE
            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                navController.navigate(ROUT_LOGIN)
            }
        }

    }
    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUT_LOGIN)
    }
    fun isloggedin():Boolean{
        return mAuth.currentUser !=null
    }

}

