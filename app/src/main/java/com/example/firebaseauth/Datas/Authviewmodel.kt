package com.example.firebaseauth.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.firebaseauth.models.User
import com.example.firebaseauth.navigation.ROUT_HOME
import com.example.firebaseauth.navigation.ROUT_LOGIN
import com.example.firebaseauth.navigation.ROUT_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Authviewmodel(var navController:NavHostController, var context:Context){

    var mAuth:FirebaseAuth
    val progress:ProgressDialog

    init {
        mAuth= FirebaseAuth.getInstance()
        progress= ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please Wait...")
    }
    fun signup(email:String,pass:String,confpass:String){

        if (email.isBlank() || pass.isBlank() ||confpass.isBlank()){
            Toast.makeText(context,"Please email and password cannot be blank",Toast.LENGTH_LONG).show()
            return
        }else if (pass != confpass){
            Toast.makeText(context,"Password do not match",Toast.LENGTH_LONG).show()
            return
        }else {
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                if (it.isSuccessful) {
                    val userdata = User(email, pass, mAuth.currentUser!!.uid)
                    val regRef = FirebaseDatabase.getInstance().getReference()
                        .child("Users/" + mAuth.currentUser!!.uid)
                    regRef.setValue(userdata).addOnCompleteListener {
                    }


                    if (it.isSuccessful) {
                        Toast.makeText(context, "Registered Successfully", Toast.LENGTH_LONG).show()
                        navController.navigate(ROUT_LOGIN)

                    } else {
                        Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_LONG)
                            .show()
                        navController.navigate(ROUT_LOGIN)
                    }
                }
            }
        }

    }
    fun login(email: String,pass: String){
        progress.show()

        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
            progress.dismiss()
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


