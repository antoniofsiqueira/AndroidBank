package com.example.bankapp.activities

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bankapp.R


class ContaActivity :AppCompatActivity() {

    private var context: Context? = null
    private var mensagem: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.sketch)


    }
}