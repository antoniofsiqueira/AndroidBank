package com.example.bankapp.activities

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bankapp.R
import com.example.bankapp.api.Api
import com.example.bankapp.api.RestClient
import com.example.bankapp.models.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ContaActivity :AppCompatActivity() {

    private var context: Context? = null
    private var mensagem: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.sketch)
        chamadaConta(1)


    }

    fun chamadaConta(id:Int){

        val bankApi = RestClient.getClient().create(Api::class.java)
        val contaCall = bankApi.loginUser("test_user", "Test@1")

        contaCall.enqueue(object : Callback<LoginResponse> {

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val result = response.body()

            }
        }
        )
    }
}