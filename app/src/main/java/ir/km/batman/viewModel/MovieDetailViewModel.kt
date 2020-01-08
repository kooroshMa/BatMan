package ir.km.batman.viewModel

import androidx.annotation.NonNull
import io.reactivex.disposables.CompositeDisposable
import ir.km.batman.App
import ir.km.batman.AppRepository
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    @NonNull application: App, val appRepository: AppRepository) : BaseViewModel(application) {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}