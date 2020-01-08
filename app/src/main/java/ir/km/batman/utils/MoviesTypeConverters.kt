package ir.km.batman.utils

import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson
import ir.km.batman.models.MoviesListModel


class MoviesTypeConverters {
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
}