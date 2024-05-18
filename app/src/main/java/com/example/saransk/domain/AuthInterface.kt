/**
 * This class created for AuthInterface
 * Author Korovkina Valentina
 * Create date 18/05/24
 * */
package com.example.saransk.domain

import io.github.jan.supabase.gotrue.user.UserInfo

interface AuthInterface {
    suspend fun createUser(out_email: String, out_pass:String): UserInfo?
    suspend fun logIn(out_email: String, out_password: String): UserInfo?
    suspend fun logOut()
}