package com.objectboxkotlintest

import android.app.Application
import android.util.Log
import com.objectboxkotlintest.models.MyObjectBox
import io.objectbox.BoxStore
import io.objectbox.android.AndroidObjectBrowser

/**
 * Created by paulmuriithi on 05/02/2018
 */
class App : Application() {

    val TAG = "App"
    lateinit var boxStore: BoxStore
        private set

    override fun onCreate() {
        super.onCreate()
        boxStore = MyObjectBox.builder().androidContext(this).build()
        if (BuildConfig.DEBUG) {
            AndroidObjectBrowser(boxStore).start(this)
        }
        Log.e("App", "Using ObjectBox " + BoxStore.getVersion() + " (" + BoxStore.getVersionNative() + ")")
    }
}
