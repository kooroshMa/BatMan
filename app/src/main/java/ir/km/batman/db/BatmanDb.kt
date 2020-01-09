package ir.km.batman.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.km.batman.models.MovieDetailModel
import ir.km.batman.models.MoviesListModel
import ir.km.batman.models.MoviesModel

@Database(entities = [MoviesModel::class, MoviesListModel::class, MovieDetailModel::class]
    , version = 1, exportSchema = false)

abstract class BatmanDb : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}