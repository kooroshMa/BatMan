package ir.km.batman

import io.reactivex.Flowable
import ir.km.batman.db.BatmanDb
import ir.km.batman.models.MovieDetailModel
import ir.km.batman.models.MoviesListModel
import ir.km.batman.models.MoviesModel
import javax.inject.Inject

class AppRepository @Inject constructor(private val apiService: ApiService , private val batmanDb: BatmanDb) {

    val apikey = "3e974fca"
    val batman = "batman"

    fun getMoveis():Flowable<MoviesModel> = apiService.getMoviesList(apikey, batman)

    fun getMoveisFromDb():Flowable<List<MoviesModel>> = batmanDb.movieDao().getAllMovies()

    fun insertMoviesToDb(moviesModel: MoviesModel) = batmanDb.movieDao().insertMovie(moviesModel)

    fun getMovieDetail(movieListModel: MoviesListModel?): Flowable<MovieDetailModel> =
        apiService.getMovieDetails(apikey,movieListModel?.imbdID)

    fun insertMovieDetailsToDb(movieDetailModel: MovieDetailModel) = batmanDb.movieDao()
        .insertMovieDetails(movieDetailModel)

    fun getMovieDetailsFromDb(imdbID:String?):Flowable<List<MovieDetailModel>> = batmanDb.movieDao().getMovieDetail(imdbID)

}