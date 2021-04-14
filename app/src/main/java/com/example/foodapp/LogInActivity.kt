package com.example.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.foodapp.databinding.ActivityLogInBinding
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlin.math.log

class LogInActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLogInBinding
    private var loginAccount = UserAccount("default name","default email","default pass")
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_log_in)

        back_from_login.setOnClickListener {
            finish()
        }

        val intent = intent
        loginAccount.email = intent.getStringExtra("loginEmail").toString()
        loginAccount.password = intent.getStringExtra("loginPassword").toString()

        binding.apply {
            LoginButton.setOnClickListener{
                if(!LoginEmailEntered.text.equals(loginAccount.email))
                    Toast.makeText(this@LogInActivity,"This email is not existed!",Toast.LENGTH_SHORT).show()
                else if(!LoginPasswordEntered.text.equals(loginAccount.password))
                    Toast.makeText(this@LogInActivity,"Wrong password",Toast.LENGTH_SHORT).show()
                else Toast.makeText(this@LogInActivity,"Login successfully",Toast.LENGTH_SHORT).show()

            }
        }

    }
}