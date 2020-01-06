package ir.km.batman.di.modules

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ir.km.batman.utils.ViewModelFactory

@Module
abstract class ViewModelFactoryModule {


    @Binds
    abstract fun viewModel(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}