package ir.km.batman.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.km.batman.views.activities.MainActivity
import ir.km.batman.views.activities.MovieDetailActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun moviesDetailActivity(): MovieDetailActivity

}