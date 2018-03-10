package com.chintansoni.android.architecturecomponentsblueprint.model.api.getusers.response

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class RandomUserResponse(

        @field:SerializedName("results")
        val results: ArrayList<ResultsItem?>? = null,

        @field:SerializedName("info")
        val info: Info? = null
)