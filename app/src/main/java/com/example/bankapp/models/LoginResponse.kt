package com.example.bankapp.models

import com.example.bankapp.api.ErrorApi
import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName ("userAccount")
    val userAccount: UserAccount,
    @SerializedName ("error")
    val error:ErrorApi)