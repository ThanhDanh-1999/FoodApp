package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.foodapp.databinding.ActivityProfileBinding
import kotlinx.android.synthetic.main.edit_profile_dialog.view.*
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProfileBinding
    private var viewModel: ProfileViewModel = ProfileViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_profile)

        back_from_profile.setOnClickListener{
            finish()
        }

        edit_profile_button.setOnClickListener{changeInfo()}
        newname.setOnClickListener{changeInfo()}
        newnumber.setOnClickListener{changeInfo()}
        newemail.setOnClickListener{changeInfo()}

        var intent = intent
        viewModel.account.value = intent.getSerializableExtra("account") as UserAccount

        binding.apply {
            account = viewModel.account.value
        }
        viewModel.account.observe(this, Observer {
            it.name.also { binding.Username.text }
            binding.newname.text = it.email
            binding.newemail.text = it.name
            binding.newnumber.text = it.password
        })
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
            binding.account?.name = mDialogView.dialogNameEt.text.toString()
            binding.account?.email = mDialogView.dialogEmailEt.text.toString()
            binding.account?.password = mDialogView.dialogPasswEt.text.toString()

            //set the input text in TextView
            mAlertDialog.dismiss()
        }
    }
}