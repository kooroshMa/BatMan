package ir.km.batman.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
class RatingModel(
    @PrimaryKey
    @SerializedName("Source") val source: String,
    @SerializedName("Value") val value: String
) {
}