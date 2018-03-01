package com.chintansoni.android.architecturecomponentsblueprint.model.api.getusers.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Login(

	@field:SerializedName("sha1")
	val sha1: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("salt")
	val salt: String? = null,

	@field:SerializedName("sha256")
	val sha256: String? = null,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("md5")
	val md5: String? = null
)