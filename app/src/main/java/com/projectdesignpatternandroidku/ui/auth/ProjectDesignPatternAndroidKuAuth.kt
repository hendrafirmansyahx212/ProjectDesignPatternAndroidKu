package com.projectdesignpatternandroidku.ui.auth

import android.content.ComponentCallbacks
import android.content.Context
import com.projectdesignpatternandroidku.data.model.ActionState
import com.projectdesignpatternandroidku.data.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object ProjectDesignPatternAndroidKuAuth {
    fun logout(context: Context, callback: ((ActionState<Boolean>)-> Unit)?){
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.logout()
            withContext(Dispatchers.Main){
                if (callback != null) callback.invoke(resp)
            }
        }
    }
}