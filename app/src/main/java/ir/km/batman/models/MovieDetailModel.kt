package ir.km.batman.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import ir.km.batman.utils.TypeConverter


@Entity
@TypeConverters(TypeConverter::class)
class MovieDetailModel(@PrimaryKey(autoGenerate = true)@SerializedName("id")val id:Int,
                       @SerializedName("Title") val title:String,
                       @SerializedName("Year")val year:String,
                       @SerializedName("Rated")val rated:String,
                       @SerializedName("Released")val released:String,
                       @SerializedName("Runtime")val runtime:String,
                       @SerializedName("Genre")val genre:String,
                       @SerializedName("Director")val director:String,
                       @SerializedName("Writer")val writer:String,
                       @SerializedName("Actors")val actors:String,
                       @SerializedName("Plot")val plot:String,
                       @SerializedName("Language")val language:String,
                       @SerializedName("Country")val country:String,
                       @SerializedName("Awards")val awards:String,
                       @SerializedName("Poster")val poster:String,
                       @SerializedName("Ratings")val ratings:List<RatingModel>,
                       @SerializedName("Metascore")val metaScore:String,
                       @SerializedName("imdbRating")val imdbRatingv:String,
                       @SerializedName("imdbVotes")val imdbVotes:String,
                       @SerializedName("imdbID")val imdbID:String,
                       @SerializedName("Type")val type:String,
                       @SerializedName("DVD")val dVD:String,
                       @SerializedName("BoxOffice")val boxOffice:String,
                       @SerializedName("Production")val production:String,
                       @SerializedName("Website")val websitev:String,
                       @SerializedName("Response")val response:String) {
}