package com.omeriyioz.data.network.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Data(

    @SerializedName("offset") var offset: String? = null,
    @SerializedName("limit") var limit: String? = null,
    @SerializedName("total") var total: String? = null,
    @SerializedName("count") var count: String? = null,
    @SerializedName("results") var results: ArrayList<Result> = arrayListOf()

)