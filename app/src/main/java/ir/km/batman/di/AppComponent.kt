package ir.km.batman.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ir.km.batman.App
import ir.km.batman.di.modules.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        RoomModule::class,
        RetrofitModule::class,
        ActivityBuilder::class,
        ViewModelFactoryModule::class]
)
interface AppComponent : AndroidInjector<App> {


    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<App>{
        interface Factory {
            fun create(@BindsInstance application: Context): AppComponent
        }
    }

    /*@Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }*/

}