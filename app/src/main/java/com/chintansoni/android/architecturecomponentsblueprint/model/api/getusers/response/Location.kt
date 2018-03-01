package com.chintansoni.android.architecturecomponentsblueprint.model.api.getusers.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Location(

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("street")
	val street: String? = null,

	@field:SerializedName("postcode")
	val postcode: String? = null,

	@field:SerializedName("state")
	val state: String? = null
)