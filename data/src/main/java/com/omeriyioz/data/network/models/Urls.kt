package com.omeriyioz.data.network.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Urls(

    @SerializedName("type") var type: String? = null,
    @SerializedName("url") var url: String? = null

)