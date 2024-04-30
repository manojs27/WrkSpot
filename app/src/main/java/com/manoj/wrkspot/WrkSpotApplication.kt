package com.manoj.wrkspot

import android.app.Application
import com.manoj.wrkspot.worker.NetworkMonitoringUtil
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WrkSpotApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val mNetworkMonitoringUtil = NetworkMonitoringUtil(applicationContext)
        mNetworkMonitoringUtil.checkNetworkState()
        mNetworkMonitoringUtil.registerNetworkCallbackEvents()
    }
}