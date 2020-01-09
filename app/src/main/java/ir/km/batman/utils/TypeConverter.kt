package ir.km.batman.utils

import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson
import ir.km.batman.models.MovieDetailModel
import ir.km.batman.models.MoviesListModel
import ir.km.batman.models.RatingModel


class TypeConverter {
    @TypeConverter
    fun stringToMeasurements(json: String): List<MoviesListModel> {
        val gson = Gson()
        val type = object : TypeToken<List<MoviesListModel>>() {

        }.type
        return gson.fromJson<List<MoviesListModel>>(json, type)
    }

    @TypeConverter
    fun measurementsToString(list: List<MoviesListModel>): String {
        val gson = Gson()
        val type = object : TypeToken<List<MoviesListModel>>() {

        }.type
        return gson.toJson(list, type)
    }


    @TypeConverter
    fun stringToRatings(json: String): List<RatingModel> {
        val gson = Gson()
        val type = object : TypeToken<List<RatingModel>>() {

        }.type
        return gson.fromJson<List<RatingModel>>(json, type)
    }

    @TypeConverter
    fun ratingsToString(list: List<RatingModel>): String {
        val gson = Gson()
        val type = object : TypeToken<List<RatingModel>>() {
        }.type
        return gson.toJson(list, type)
    }
}