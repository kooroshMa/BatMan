package ir.km.batman

import io.reactivex.Flowable
import ir.km.batman.models.MovieDetailsModel
import ir.km.batman.models.MoviesModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/")
    fun getMoviesList(@Query("apikey") apikey:String , @Query("s")batman:String):
            Flowable<MoviesModel>

    @GET("/")
    fun getMovieDetails(@Query("apikey") apikey: Int , @Query("i") i:String):
            Flowable<MovieDetailsModel>
}