package com.example.androidstudy.app

import android.app.Application
import android.view.View
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.example.androidstudy.vm.AppScope
/**
 * 全局的ViewModel
 * 首先 要对Application 实现 ViewModelStoreOwner接口
 */
class MyApp: Application(), ViewModelStoreOwner {
    private val TAG = "MyApp"

    private val appViewModelStore: ViewModelStore by lazy {
        ViewModelStore()
    }

    override fun onCreate() {
        super.onCreate()
        AppScope.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        appViewModelStore.clear()
    }

    override fun getViewModelStore(): ViewModelStore {
        return appViewModelStore
    }

}