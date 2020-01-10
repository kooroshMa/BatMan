package ir.km.batman.viewModel

import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ir.km.batman.App
import ir.km.batman.AppRepository
import ir.km.batman.base.BaseViewModel
import ir.km.batman.models.MovieDetailModel
import ir.km.batman.models.MoviesListModel
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    @NonNull application: App, val appRepository: AppRepository
) : BaseViewModel(application) {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var moviesListModel: MoviesListModel? = null


    val movieDetailsLiveData = MutableLiveData<MovieDetailModel>()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun getExtra(moviesListModel: MoviesListModel?): MoviesListModel? {
        this.moviesListModel = moviesListModel
        getMovieDetail()
        return moviesListModel
    }


    fun getMovieDetail(): Disposable {
        return appRepository.getMovieDetail(moviesListModel).subscribeOn(Schedulers.io())
            .onBackpressureLatest().subscribe(
                {
                    appRepository.insertMovieDetailsToDb(it)
                    getMovieDetailsFromDb()
                },
                {

                    if (it.message.toString().contains("Unable to resolve host")) {
                        getMovieDetailsFromDb()
                    }
                }).also { compositeDisposable.add(it) }
    }

    fun getMovieDetailsFromDb(): Disposable {
        return appRepository.getMovieDetailsFromDb().subscribeOn(Schedulers.io())
            .onBackpressureLatest().subscribe(
                {
                    if (it.isEmpty()) {
                        Log.i("No Connection And Data", "Please Connect To Internet")
                    } else {
                        movieDetailsLiveData.postValue(it[0])
                    }
                },
                {

                }).also { compositeDisposable.add(it) }
    }
}