package com.example.bankapp.api

import com.google.gson.annotations.SerializedName

data class ErrorApi (
    @SerializedName("code")
    var code: Int,
    @SerializedName("message")
    var massage: String
)



