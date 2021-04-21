package com.example.foodapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.databinding.ActivitySignUpBinding
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUpActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignUpBinding
    private lateinit var viewModel : SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        binding.apply {
            SignUpButton.setOnClickListener{
                var passwordFlag = false
                var emailFlag = false
                val textEmail = SignupEmailEntered.text.toString()
                if (textEmail.isEmpty()){
                    SignupEmailEntered.error = "Your email must match !"
                }
                else if (!isEmailValid(textEmail)){
                    SignupEmailEntered.error = "Your email is invalid !";
                } else emailFlag=true
                val textPassword = SignupPasswordEntered.text.toString()
                if (textPassword.isEmpty())
                    SignupPasswordEntered.error = "Your passwords must match !"
                else if (textPassword.length < 8) {
                    SignupPasswordEntered.error = "Your passwords must be at least 8 characters in length !"
                } else if (!checkString(textPassword)) {
                    SignupPasswordEntered.error = "Your passwords must have Capital letters, Lowercase letters, Number and Special characters !"
                } else passwordFlag=true
                if (emailFlag&&passwordFlag){
                    Toast.makeText(this@SignUpActivity, "Sign up successfully!\n", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@SignUpActivity, LogInActivity::class.java)
                    intent.putExtra("SignedUpAccount", account)
                    startActivity(intent)
                } else if (!emailFlag&&!passwordFlag)
                    Toast.makeText(this@SignUpActivity, "Your email is invalid !" +
                            "\nYour password is invalid !", Toast.LENGTH_SHORT).show()
                else if (!emailFlag&&passwordFlag)
                    Toast.makeText(this@SignUpActivity, "Your email is invalid !", Toast.LENGTH_SHORT).show()
                else Toast.makeText(this@SignUpActivity, "Your password is invalid !", Toast.LENGTH_SHORT).show()

            }
            SignupEmailEntered.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    val text = SignupEmailEntered.text.toString()
                    if (text.isEmpty())
                        SignupEmailEntered.error = "Your email must match !"
                    else if (!isEmailValid(text))
                        SignupEmailEntered.error = "Your email is invalid !";
                }

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
                override fun afterTextChanged(s: Editable) {}
            })
            SignupPasswordEntered.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    val text = SignupPasswordEntered.text.toString()
                    if (text.isEmpty())
                        SignupPasswordEntered.error = "Your passwords must match !"
                    else if (text.length < 8) {
                        SignupPasswordEntered.error = "Your passwords must be at least 8 characters in length !"
                    } else {
                        if (!checkString(text)) {
                            SignupPasswordEntered.error = "Your passwords must have Capital letters, Lowercase letters, Number and Special characters !"
                        }
                    }

                }

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
                override fun afterTextChanged(s: Editable) {}
            })
            GoToLoginFormSignUp.setOnClickListener{
                val intent = Intent(this@SignUpActivity, LogInActivity::class.java)
                intent.putExtra("SignedUpAccount", account)

                startActivity(intent)
            }
            binding.account = viewModel.account
        }
    }

    fun isEmailValid(email: CharSequence?): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun checkString(str: String): Boolean {
        var ch: Char
        var capitalFlag = false
        var lowerCaseFlag = false
        var numberFlag = false
        var specialFlag = false
        val special = arrayListOf('!', '@', '$', '%', '^', '&', '*', '(', ')')
        for (element in str) {
            ch = element
            when {
                Character.isDigit(ch) -> {
                    numberFlag = true
                }
                Character.isUpperCase(ch) -> {
                    capitalFlag = true
                }
                Character.isLowerCase(ch) -> {
                    lowerCaseFlag = true
                }

            }
            for (i in special) {
                if (str.contains(i)) specialFlag = true
            }
            if (numberFlag && capitalFlag && lowerCaseFlag && specialFlag) return true
        }
        return false
    }
}