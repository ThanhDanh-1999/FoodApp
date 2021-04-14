package com.example.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.databinding.ActivitySignUpBinding
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignUpBinding
    private lateinit var viewModel : SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up)
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        binding.apply {
            SignUpButton.setOnClickListener{
                account?.name = SignupFullnameEntered.toString().trim()
                account?.email = SignupEmailEntered.toString().trim()
                account?.password = SignupPasswordEntered.toString().trim()
                //viewModel.account = account

                Toast.makeText(this@SignUpActivity,"Sign up successfully!",Toast.LENGTH_LONG).show()
            }

            GoToLoginFormSignUp.setOnClickListener{
                val intent = Intent(this@SignUpActivity,LogInActivity::class.java)
                intent.putExtra("userName",account?.name)
                intent.putExtra("loginEmail",account?.email)
               intent.putExtra("loginPassword",account?.password)

                startActivity(intent)
            }
            binding.account = viewModel.account
        }
    }
}