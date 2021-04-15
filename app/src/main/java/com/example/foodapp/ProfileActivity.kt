package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
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

        var intent = intent
        viewModel.account.value = intent.getSerializableExtra("account") as UserAccount
        edit_profile_button.setOnClickListener{changeInfo()}
        newname.setOnClickListener{changeInfo()}
        newnumber.setOnClickListener{changeInfo()}
        newemail.setOnClickListener{changeInfo()}

        binding.apply {
            edit_profile_button.setOnClickListener{changeInfo()}
            newname.setOnClickListener{changeInfo()}
            newnumber.setOnClickListener{changeInfo()}
            newemail.setOnClickListener{changeInfo()}
            account = viewModel.account.value
        }

        viewModel.account.observe(this, Observer {
            Log.d("test",it.name)
            Username.text = it.name
            newname.text = it.name
            newemail.text = it.email
            newnumber.text = it.password
        })
    }

    private fun changeInfo() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.edit_profile_dialog, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this).setView(mDialogView).setTitle("Edit Profile")
        //show dialog
        val  mAlertDialog = mBuilder.show()
        //login button click of custom layout
        mDialogView.change_confirm_button.setOnClickListener {
            //get text from EditTexts of custom layout
            viewModel.account.value?.name = mDialogView.dialogNameEt.text.toString().trim()

            viewModel.account.value?.email = mDialogView.dialogEmailEt.text.toString().trim()
            viewModel.account.value?.password = mDialogView.dialogPasswEt.text.toString().trim()
            viewModel.account.postValue(viewModel.account.value)
            Log.d("test",mDialogView.dialogPasswEt.text.toString().trim())

            Toast.makeText(this@ProfileActivity,"Profile updated",Toast.LENGTH_SHORT).show()

            //set the input text in TextView
            mAlertDialog.dismiss()
        }
    }
}