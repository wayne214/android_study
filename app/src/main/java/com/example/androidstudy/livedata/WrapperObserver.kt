package com.example.androidstudy.livedata

import androidx.lifecycle.Observer

class WrapperObserver<T>(
    val liveData: NoStickyLiveData<T>,
    var observer: Observer<in T>,
    sticky: Boolean,
    observerForever: Boolean = false
): Observer<T> {
    private val TAG = "WrapperObserver"
    private var mLastVersion = if(sticky) {
        -1
    } else {
        liveData.getVersion()
    }
    override fun onChanged(t: T) {
        if (mLastVersion >= liveData.getVersion()){
            return
        }
        mLastVersion = liveData.getVersion()
        observer.onChanged(t)
    }
}