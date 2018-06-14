package com.magicalrice.adolph.smallmicrowave

import android.app.Application
import mc.df.es.AdManager

/**
 * Created by Adolph on 2018/6/14.
 */
class MwApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AdManager.getInstance(this).init("08fbc507b935fd07","334b5b0bedc6f59c",true)
    }
}