package ir.km.batman.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
class RatingModel(
    @PrimaryKey(autoGenerate = true)@SerializedName("id") val id:Int,
    @SerializedName("Source") val source: String,
    @SerializedName("Value") val value: String
) {
}