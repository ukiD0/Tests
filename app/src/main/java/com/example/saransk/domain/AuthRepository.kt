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
        fun checkInvalidPassAlert(editText: EditText): Boolean {
            val upper = editText.text.any { it.isUpperCase() }
            val under = editText.text.any { it.isLowerCase() }
            val digit = editText.text.any { it.isDigit() }
            val special = editText.text.any { it.isSpecialChar() }
            Log.e("1",upper.toString())
            Log.e("1",under.toString())
            Log.e("1",digit.toString())
            Log.e("1",special.toString())
            return(!upper || !under || !digit || !special)
        }
        fun checkValidEmail(editText: EditText): Boolean {
            val name = editText.text.split("@")[0]
            val domain = editText.text.split("@")[1].split(".")[0]
            val dopistimiiZnach = "abcdefghijklmnopqrstuvwxyz0123456789"
            return name.all { it in dopistimiiZnach } && domain.all { it in dopistimiiZnach}
        }
        fun checkInvalidEMailAlert(editText: EditText): Boolean {
            val name = editText.text.split("@")[0]
            val domain = editText.text.split("@")[1].split(".")[0]
            val dopistimiiZnach = "abcdefghijklmnopqrstuvwxyz0123456789"
            return  name.all { it in dopistimiiZnach } && domain.all { it in dopistimiiZnach}
        }
    }
}