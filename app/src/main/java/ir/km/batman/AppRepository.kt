package ir.km.batman

import io.reactivex.Flowable
import ir.km.batman.db.BatmanDb
import ir.km.batman.models.MoviesModel
import javax.inject.Inject

class AppRepository @Inject constructor(private val apiService: ApiService , private val batmanDb: BatmanDb) {

    val apikey = "3e974fca"
    val batman = "batman"

    fun getMoveis():Flowable<MoviesModel> = apiService.getMoviesList(apikey, batman)

    fun getMoveisFromDb():Flowable<List<MoviesModel>> = batmanDb.movieDao().getAllMovies()

    fun insertMoviesToDb(moviesModel: MoviesModel) = batmanDb.movieDao().insertMovie(moviesModel)


   /*
    fun insertUsersToDb(userModel: List<UserModel>) = userDb.userDao().insert(userModel)
 */
}