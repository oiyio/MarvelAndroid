package com.omeriyioz.data.network.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Items(

    @SerializedName("resourceURI") var resourceURI: String? = null,
    @SerializedName("name") var name: String? = null

)