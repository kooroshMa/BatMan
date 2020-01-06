package ir.km.batman

import io.reactivex.Flowable
import javax.inject.Inject

//class AppRepository @Inject constructor(private val apiService: ApiService , private val userDb: UserDb) {
class AppRepository @Inject constructor(private val apiService: ApiService) {

   /* fun getUsers() : Flowable<List<UserModel>> = apiService.getUsers()

    fun insertUsersToDb(userModel: List<UserModel>) = userDb.userDao().insert(userModel)

    fun getAllUsers():Flowable<List<UserModel>> = userDb.userDao().getAllUsers()*/
}