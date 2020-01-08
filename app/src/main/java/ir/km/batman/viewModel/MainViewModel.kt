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


class MainViewModel @Inject constructor(
    @NonNull application: App, val appRepository: AppRepository) :
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
                    appRepository.insertMoviesToDb(it)
                    getMoviesFromDb()
                },
                {
                    if (it.message.toString().contains("Unable to resolve host")){
                        getMoviesFromDb()
                    }
                }
            ).also { compositDisposable.add(it) }
    }

    fun getMoviesFromDb(): Disposable {
        return appRepository.getMoveisFromDb()
            .subscribeOn(Schedulers.io())
            .onBackpressureLatest()
            .subscribe(
                {
                    if(it.isEmpty()){
                        Log.i("No Connection And Data" , "Please Connect To Internet")
                    }else{
                        moviesLiveData.postValue(it[0])
                    }
                },
                {
                }).also { compositDisposable.add(it) }
    }
}
