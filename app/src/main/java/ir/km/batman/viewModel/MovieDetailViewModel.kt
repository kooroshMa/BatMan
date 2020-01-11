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

    fun getExtra(moviesListModel: MoviesListModel?) {
        this.moviesListModel = moviesListModel
        getMovieDetail()
    }


    fun getMovieDetail(): Disposable {
        Log.i("joonemadaret" , moviesListModel?.imbdID.toString())
        return appRepository.getMovieDetail(moviesListModel).subscribeOn(Schedulers.io())
            .onBackpressureLatest().subscribe(
                {
                    Log.i("joonemadaret" , it.title)

                    appRepository.insertMovieDetailsToDb(it)
                    getMovieDetailsFromDb(moviesListModel?.imbdID)
                },
                {

                    if (it.message.toString().contains("Unable to resolve host")) {
                        getMovieDetailsFromDb(moviesListModel?.imbdID)
                    }
                }).also { compositeDisposable.add(it) }
    }

    fun getMovieDetailsFromDb(imdbId:String?): Disposable {
        return appRepository.getMovieDetailsFromDb(imdbId).subscribeOn(Schedulers.io())
            .onBackpressureLatest().subscribe(
                {
                    if (it.isEmpty()) {
                        Log.i("No Connection And Data", "Please Connect To Internet")
                    } else {
                        /*it.forEach { s -> Log.i("whywhywhy" , s.title) }
                        val s = it.filter { s -> s.title.trim() == moviesListModel?.title?.trim() }*/
                        movieDetailsLiveData.postValue(it[0])
                    }
                },
                {

                }).also { compositeDisposable.add(it) }
    }
}