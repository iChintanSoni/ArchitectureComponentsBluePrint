package com.chintansoni.android.architecturecomponentsblueprint.model.api.getusers.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Info(

	@field:SerializedName("seed")
	val seed: String? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("results")
	val results: Int? = null,

	@field:SerializedName("version")
	val version: String? = null
)