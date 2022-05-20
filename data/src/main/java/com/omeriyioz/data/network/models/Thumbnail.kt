package com.omeriyioz.data.network.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Thumbnail(

    @SerializedName("path") var path: String? = null,
    @SerializedName("extension") var extension: String? = null

)