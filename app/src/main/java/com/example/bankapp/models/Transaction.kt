package com.example.bankapp.models

data class Transaction (
                var title: String,
                var desc: String,
                var date: String,
                var valor: Double? = null)
