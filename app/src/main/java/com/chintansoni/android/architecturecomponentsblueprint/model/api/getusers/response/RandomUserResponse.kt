package com.chintansoni.android.architecturecomponentsblueprint.model.api.getusers.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class RandomUserResponse(

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null,

	@field:SerializedName("info")
	val info: Info? = null
)