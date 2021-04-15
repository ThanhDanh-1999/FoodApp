package com.example.foodapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var account  = UserAccount("","", "")
}

class SignUpViewModel : ViewModel() {
    var account  = UserAccount("","", "")
}

class ProfileViewModel : ViewModel() {
    var account : MutableLiveData<UserAccount> = MutableLiveData()
    init {
        account.value = UserAccount("", "","")
    }
}