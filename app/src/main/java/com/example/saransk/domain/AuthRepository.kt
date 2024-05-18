/**
 * This class created for AuthRepository
 * Author Korovkina Valentina
 * Create date 18/05/24
 * */
package com.example.saransk.domain

import android.util.Log
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.saransk.data.DbCon
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.gotrue.user.UserInfo

class AuthRepository:ViewModel(),AuthInterface {

    var _user: MutableLiveData<UserInfo> = MutableLiveData()

    init {
        _user.value = DbCon.supabase.auth.currentUserOrNull()
    }
    override suspend fun createUser(out_email: String, out_pass:String): UserInfo? {
        DbCon.supabase.auth.signUpWith(Email){
            email = out_email
            password = out_pass
        }
        return DbCon.supabase.auth.currentUserOrNull()
    }
     override suspend fun logIn(out_email: String, out_password: String): UserInfo? {
        DbCon.supabase.auth.signInWith(Email){
            email = out_email
            password = out_password
        }
        return DbCon.supabase.auth.currentUserOrNull()
    }
    override suspend fun logOut(){
        DbCon.supabase.auth.signOut()
    }

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