package com.magicalrice.adolph.smallmicrowave

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import mc.df.es.nm.sp.SplashViewSettings
import mc.df.es.nm.sp.SpotListener
import mc.df.es.nm.sp.SpotManager
import mc.df.es.nm.sp.SpotRequestListener

/**
 * Created by Adolph on 2018/6/14.
 */
class SplashActivity : Activity() , SpotRequestListener , SpotListener{
    private val TAG = "SplashActivity"
    private var adView:RelativeLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        adView = findViewById(R.id.rl_splash)
        SpotManager.getInstance(this).requestSpot(this)
        var splashSetting = SplashViewSettings()
        splashSetting.isAutoJumpToTargetWhenShowFailed = false
        splashSetting.setTargetClass(MainActivity::class.java)
        splashSetting.setSplashViewContainer(adView)
        SpotManager.getInstance(this).showSplash(this,splashSetting,this)
    }

    override fun onRequestFailed(p0: Int) {
        Log.e(TAG,"onRequestFailed" + p0)
    }

    override fun onRequestSuccess() {
        Log.e(TAG,"onRequestSuccess")
    }

    override fun onSpotClicked(p0: Boolean) {
        Log.e(TAG,"onSpotClicked" + p0)
    }

    override fun onShowSuccess() {
        Log.e(TAG,"onShowSuccess")

    }

    override fun onShowFailed(p0: Int) {
        Log.e(TAG,"onShowFailed" + p0)

    }

    override fun onSpotClosed() {
        Log.e(TAG,"onSpotClosed")
    }

    override fun onDestroy() {
        super.onDestroy()
        SpotManager.getInstance(this).onDestroy()
    }
}