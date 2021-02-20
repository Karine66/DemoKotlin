package com.karine.demokotlin

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.karine.demokotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    var fullName = ""
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        val preferencesReader = getSharedPreferences("com.karine.demokotlin", MODE_PRIVATE)
        fullName = preferencesReader.getString("User fullName", "").toString()
        welcomeUser()
    }

    @SuppressLint("SetTextI18n")
    fun goButtonTouched(button: View) {
        val firstName = mainBinding.firstNameField.text
        val lastName = mainBinding.lastNameField.text
        if (firstName.length > 0 && lastName.length > 0) {
            fullName = "$firstName $lastName"
            val sharedPreferences = getSharedPreferences("com.karine.demokotlin", MODE_PRIVATE).edit()
           sharedPreferences.putString("User fullName", fullName)
            sharedPreferences.apply()
        }else {
            fullName = ""
        }
            welcomeUser()
    }

    @SuppressLint("SetTextI18n")
    fun clearButtonTouched(button: View) {
        fullName = ""
        welcomeUser()
    }

    fun welcomeUser() {
        if (fullName.length > 0) {
            mainBinding.resultView.text = "Bonjour $fullName"
        }else{
            mainBinding.resultView.text = "Saisissez d'abord votre nom et prénom "
        }
            mainBinding.firstNameField.setText("")
            mainBinding.lastNameField.setText("")
        }
    }
