package com.example.foodapp

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var account  = UserAccount("defaul name","defaul email", "default password")
}

class SignUpViewModel : ViewModel() {
    var account  = UserAccount("defaul name","defaul email", "default password")
}