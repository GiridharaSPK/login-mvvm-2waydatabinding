package com.giridhara.logintest

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.giridhara.logintest.databinding.ActivityLoginBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

//    private lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
//        factory = LoginViewModelFactory()
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        initView()
    }

    private fun initView() {
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setObservers()
    }

    private fun setObservers() {
        viewModel.show.observe(this, {
            showAlertDialog(it)
        })
    }

    private fun showAlertDialog(s: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Login")
        builder.setMessage(s)
        builder.setPositiveButton(android.R.string.ok) { dialog, which ->
            dialog.dismiss()
        }
        builder.show()
    }
}