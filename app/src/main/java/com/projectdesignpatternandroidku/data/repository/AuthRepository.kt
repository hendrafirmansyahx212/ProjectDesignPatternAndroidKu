package com.projectdesignpatternandroidku.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.projectdesignpatternandroidku.data.local.AuthPref
import com.projectdesignpatternandroidku.data.model.ActionState
import com.projectdesignpatternandroidku.data.model.AuthUser

class AuthRepository(val context: Context) {
    private val authPref: AuthPref by lazy { AuthPref(context) }

    val authUser = MutableLiveData<AuthUser>(authPref.authUser)
    val isLogin =  MutableLiveData<Boolean>(authPref.isLogin)

    suspend fun login(email: String, pasword: String) : ActionState<AuthUser>{
        return authPref.login(email,pasword)
    }

    suspend fun register(user: AuthUser) : ActionState<AuthUser>{
        return authPref.register(user)
    }

    suspend fun logout() : ActionState<Boolean>{
        return authPref.logout()
    }
}