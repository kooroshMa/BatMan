package ir.km.batman.models

import com.google.gson.annotations.SerializedName

class MovieDetailsModel(@SerializedName("Title") var title:String,
                        @SerializedName("Year") var year:String,
                        @SerializedName("imdbID")var imbdID:String,
                        @SerializedName("Type")var type:String,
                        @SerializedName("Poster")var poster:String)
