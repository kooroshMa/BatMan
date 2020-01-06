package ir.km.batman.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class MoviesModel(@SerializedName("Search") var search:List<MovieDetailsModel>,
                  @SerializedName("totalResults")var totalResults: String ,
                  @SerializedName("Response")var response: String)
