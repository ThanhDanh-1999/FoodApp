package com.example.foodapp

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var account  = UserAccount("","", "")
}

class SignUpViewModel : ViewModel() {
    var account  = UserAccount("","", "")
}