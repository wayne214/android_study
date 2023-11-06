package com.example.androidstudy.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidstudy.app.MyApp
/**
 * 构建全局 appScopeViewModel
 * 可用于activity 通信
 */
object AppScope {
    private lateinit var myApp: MyApp
    fun init(application: MyApp) {
        myApp = application
    }
    /**
     * 获取进程共享的ViewModel
     */
    fun<T: ViewModel?> getAppScopeViewModel(modelClass: Class<T>) : T {
        return ViewModelProvider(myApp).get(modelClass)
    }
}