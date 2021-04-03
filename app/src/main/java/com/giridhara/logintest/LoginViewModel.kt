package com.giridhara.logintest

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {
    val show: MutableLiveData<String> = MutableLiveData()

    var email: String = ""
    var password: String = ""
    var confirmpassword: String = ""

    fun login() {
        if (email.isBlank()) {
            show.postValue("Please enter email to login")
            return
        } else if (!isEmailValid()) {
            show.postValue("Please enter a valid email")
            return
        } else if (password.isBlank()) {
            show.postValue("Please enter Password to login")
            return
        } else if (confirmpassword.isBlank()) {
            show.postValue("Please confirm password to login")
            return
        } else if (password != confirmpassword) {
            show.postValue("Confirm password should be same as password")
            return
        }
        show.postValue("Success")
        return
    }

    private fun isEmailValid(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


}