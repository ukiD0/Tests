package com.example.saransk.domain

import android.widget.EditText
import androidx.lifecycle.ViewModel

class AuthRepository:ViewModel(),AuthInterface {

    companion object{
        fun Char.isSpecialChar(): Boolean {
            return false
        }
        fun checkValidPass(editText: EditText): Boolean {
            return false
        }
        fun checkInvalidPassAlert(editText: EditText): Boolean {
            return false
        }
        fun checkValidEmail(editText: EditText): Boolean {
            return false
        }
        fun checkInvalidEMailAlert(editText: EditText): Boolean {
            return false
        }
    }
}