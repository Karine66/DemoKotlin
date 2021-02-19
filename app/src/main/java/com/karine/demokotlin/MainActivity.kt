package com.karine.demokotlin

import android.annotation.SuppressLint
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
    }

    @SuppressLint("SetTextI18n")
    fun goButtonTouched(button: View) {
        val firstName = mainBinding.firstNameField.text
        val lastName = mainBinding.lastNameField.text
        if (firstName.length > 0 && lastName.length > 0) {
            fullName = "$firstName $lastName"
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
