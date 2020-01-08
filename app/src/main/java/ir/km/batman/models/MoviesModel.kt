package ir.km.batman.models

import androidx.room.*
import com.google.gson.annotations.SerializedName
import ir.km.batman.utils.MoviesTypeConverters
import java.lang.reflect.Constructor


@Entity
@TypeConverters(MoviesTypeConverters::class)
class MoviesModel(
    @PrimaryKey(autoGenerate = true)@SerializedName("id") var id: Int,
    @SerializedName("Search") var search: List<MoviesListModel>,
    @SerializedName("totalResults") var totalResults: String,
    @SerializedName("Response") var response: String

)


