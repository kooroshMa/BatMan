package ir.km.batman.viewModel

import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ir.km.batman.App
import ir.km.batman.AppRepository
import ir.km.batman.models.MoviesModel
import javax.inject.Inject


class MainViewModel @Inject constructor(@NonNull application: App, val appRepository: AppRepository) :
    BaseViewModel(application) {

    private val compositDisposable: CompositeDisposable = CompositeDisposable()

    init {
        getMovies()
    }

    val moviesLiveData = MutableLiveData<MoviesModel>()

    override fun onCleared() {
        super.onCleared()
        compositDisposable.clear()
    }

    fun getMovies(): Disposable {
        return appRepository.getMoveis()
            .subscribeOn(Schedulers.io())
            .onBackpressureLatest()
            .subscribe(
                {
                    moviesLiveData.postValue(it)
                },
                {
                }
            ).also { compositDisposable.add(it) }
    }


}
