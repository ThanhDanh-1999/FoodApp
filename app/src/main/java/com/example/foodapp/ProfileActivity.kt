package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.foodapp.databinding.ActivityProfileBinding
import kotlinx.android.synthetic.main.edit_profile_dialog.view.*
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_profile)

        back_from_profile.setOnClickListener{
            finish()
        }

        edit_profile_button.setOnClickListener{
            val buider = AlertDialog.Builder(this)
        }

        edit_profile_button.setOnClickListener{changeInfo()}
        new_name.setOnClickListener{changeInfo()}
        new_number.setOnClickListener{changeInfo()}
        new_email.setOnClickListener{changeInfo()}

        var intent = intent

        binding.apply {
            account = intent.getSerializableExtra("account") as UserAccount
        }

    }

    private fun changeInfo() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.edit_profile_dialog, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("Edit Profile")
        //show dialog
        val  mAlertDialog = mBuilder.show()
        //login button click of custom layout
        mDialogView.change_confirm_button.setOnClickListener {
            //dismiss dialog
            mAlertDialog.dismiss()
            //get text from EditTexts of custom layout
            val name = mDialogView.dialogNameEt.text.toString()
            val email = mDialogView.dialogEmailEt.text.toString()
            val phoneNum = mDialogView.dialogPasswEt.text.toString()

            //set the input text in TextView
            new_name.text = name
            new_email.text = email
            new_number.text = phoneNum
            User_name.text = name
            mAlertDialog.dismiss()
        }
    }
}