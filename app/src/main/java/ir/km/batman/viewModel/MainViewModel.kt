package ir.km.batman.viewModel

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ir.km.batman.App
import ir.km.batman.AppRepository
import ir.km.batman.models.MoviesListModel
import ir.km.batman.models.MoviesModel
import ir.km.batman.views.activities.MovieDetailActivity
import kotlinx.android.synthetic.main.item_movie.*
import javax.inject.Inject


class MainViewModel @Inject constructor(
    @NonNull application: App, val appRepository: AppRepository) :
    BaseViewModel(application) {

    private val compositDisposable: CompositeDisposable = CompositeDisposable()


    init {
        getMovies()
    }

    val moviesLiveData = MutableLiveData<MoviesModel>()
    //val startActivityLiveData = MutableLiveData<Pair<MoviesListModel , Int>>()
    val startActivityLiveData = MutableLiveData<Triple<MoviesListModel , Int, ImageView>>()

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

    fun onItemClicked(movie: MoviesListModel , position:Int , imageView: ImageView) {
        val triple = Triple(movie , position, imageView)
        //startActivityLiveData.value = triple
      /*  val imagePair = Pair.create(movie, position)
        startActivityLiveData.value = imagePair*/
        Log.d("clickclick", "onItemClicked() called  with: movie = [${movie.imbdID}]")
        Log.d("clickclick", "onItemClicked() called  with: movie = [${position}]")
    }
}
