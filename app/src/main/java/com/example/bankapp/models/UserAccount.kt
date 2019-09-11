package com.example.bankapp.models

data class UserAccount (val userId: Int,
                        val name: String,
                        val bankAccount: Int,
                        val agency: Int,
                        val balance: Double)

