package ir.km.batman.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import ir.km.batman.models.MovieDetailModel
import ir.km.batman.models.MoviesModel

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(moviesModel: MoviesModel)

    @Query("Select * from MoviesModel")
    fun getAllMovies(): Flowable<List<MoviesModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetails(moviesDetailModel: MovieDetailModel)

    @Query("Select * from MovieDetailModel")
    fun getMovieDetail(): Flowable<List<MovieDetailModel>>
}
