package ir.km.batman

import io.reactivex.Flowable
import ir.km.batman.models.MovieDetailsModel
import ir.km.batman.models.MoviesModel
import org.intellij.lang.annotations.Flow
import javax.inject.Inject

//class AppRepository @Inject constructor(private val apiService: ApiService , private val userDb: UserDb) {
class AppRepository @Inject constructor(private val apiService: ApiService) {

    val apikey = "3e974fca"
    val batman = "batman"

    fun getMoveis():Flowable<MoviesModel> = apiService.getMoviesList(apikey, batman)

   /* fun getUsers() : Flowable<List<UserModel>> = apiService.getUsers()

    fun insertUsersToDb(userModel: List<UserModel>) = userDb.userDao().insert(userModel)

    fun getAllUsers():Flowable<List<UserModel>> = userDb.userDao().getAllUsers()*/
}