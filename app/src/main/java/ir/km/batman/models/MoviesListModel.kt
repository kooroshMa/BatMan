package ir.km.batman.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
class MoviesListModel(
    @PrimaryKey @SerializedName("Title") var title: String,
    @SerializedName("Year") var year: String,
    @SerializedName("imdbID") var imbdID: String,
    @SerializedName("Type") var type: String,
    @SerializedName("Poster") var poster: String
):Serializable


