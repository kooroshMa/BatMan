package ir.km.batman

import android.widget.Toast
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import ir.km.batman.di.DaggerAppComponent

class App : DaggerApplication() {


    override fun onCreate() {
        super.onCreate()

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(this)

}