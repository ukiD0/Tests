package com.example.saransk.domain

import android.util.Log
import android.widget.EditText
import androidx.lifecycle.ViewModel

class AuthRepository:ViewModel(),AuthInterface {

    companion object{
        fun Char.isSpecialChar(): Boolean {
            val symb = "!@#$%^&*()_+-?><."
            return this in symb
        }
        fun checkValidPass(editText: EditText): Boolean {
            val upper = editText.text.any { it.isUpperCase() }
            val under = editText.text.any { it.isLowerCase() }
            val digit = editText.text.any { it.isDigit() }
            val special = editText.text.any { it.isSpecialChar() }
            return(upper && under && digit && special)
        }
        fun checkValidEmail(editText: EditText): Boolean {
            val value = editText.text.toString().replace("@","").replace(".","")
            return value.all { it in DOPISTIMIIZNACH }
        }
        const val TEST_PASSWORD = "12345!Ab"
        const val TEST_PASSWORD_INVALID = "12345"
        const val TEST_EMAIL = "valusa@123mewo.ry"
        const val TEST_EMAIL_INVALID = "valusDDDSa@12sSSD3mewo.ry"
        const val DOPISTIMIIZNACH ="abcdefghijklmnopqrstuvwxyz0123456789"
    }
}