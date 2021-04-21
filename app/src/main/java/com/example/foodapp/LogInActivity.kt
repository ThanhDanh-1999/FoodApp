package com.example.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.databinding.ActivityLogInBinding
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlin.math.log

class LogInActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLogInBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_log_in)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        back_from_login.setOnClickListener {
            finish()
        }

        val intent = intent
        val loginAccount : UserAccount = intent.getSerializableExtra("SignedUpAccount") as UserAccount
        binding.apply {
            LoginButton.setOnClickListener{
                if(LoginEmailEntered.text.toString() != loginAccount.email)
                    Toast.makeText(this@LogInActivity,"This email is not existed!",Toast.LENGTH_SHORT).show()
                else if(LoginPasswordEntered.text.toString() != loginAccount.password)
                    Toast.makeText(this@LogInActivity,"Wrong password",Toast.LENGTH_SHORT).show()
                else
                {
                    val intent = Intent(this@LogInActivity,RestaurantsActivity::class.java)
                    intent.putExtra("account",loginAccount)

                    startActivity(intent)
                }
            }
            binding.inputAccount = viewModel.account
        }

    }
}