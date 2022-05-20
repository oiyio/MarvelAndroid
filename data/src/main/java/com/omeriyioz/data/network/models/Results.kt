package com.omeriyioz.data.network.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Results(

    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("modified") var modified: String? = null,
    @SerializedName("resourceURI") var resourceURI: String? = null,
    @SerializedName("urls") var urls: ArrayList<Urls> = arrayListOf(),
    @SerializedName("thumbnail") var thumbnail: Thumbnail? = Thumbnail(),
    @SerializedName("comics") var comics: Comics? = Comics(),
    @SerializedName("stories") var stories: Stories? = Stories(),
    @SerializedName("events") var events: Events? = Events(),
    @SerializedName("series") var series: Series? = Series()

)