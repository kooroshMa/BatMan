package ir.km.batman.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.km.batman.MainActivity

@Module
abstract class ActivityBuilder {


    @ContributesAndroidInjector(modules = [MainViewModelModule::class])
    abstract fun mainActivity() : MainActivity
}