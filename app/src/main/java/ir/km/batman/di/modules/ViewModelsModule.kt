package ir.km.batman.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ir.km.batman.viewModel.MainViewModel
import ir.km.batman.viewModel.MovieDetailViewModel
import ir.km.k.di.ViewModelKey

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun bindMovieDetailViewmodel(movieDetailViewModel: MovieDetailViewModel): ViewModel
}