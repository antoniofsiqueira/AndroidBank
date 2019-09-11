package com.example.bankapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bankapp.R
import com.example.bankapp.api.Api
import com.example.bankapp.api.RestClient
import com.example.bankapp.exibirMensagem
import com.example.bankapp.isCpf
import com.example.bankapp.isEmail
import com.example.bankapp.models.UserAccount
import kotlinx.android.synthetic.main.telainicial.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Double.parseDouble

class MainActivity : AppCompatActivity() {

    private var context: Context? = null
    private var mensagem: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telainicial)

        initVars()
        initActions()
    }

    private fun initVars() {
        context = this
        mensagem = ""
    }

    private fun initActions() {

    btn_login.setOnClickListener {
        //if(validate()){
            chamadaLogin()

        //}else{
          //  exibeErro()
       // }
     }
    }

    private fun exibeErro() {
        exibirMensagem(mensagem)
    }

    private fun validate(): Boolean {
        val usuario = et_nome.text.toString().trim()
        val senha = et_senha.text.toString().trim()
        var numeric = true

        if (usuario.isEmpty()) {
            mensagem = getString(R.string.alerta_erro_usuario_obrigatorio)
            limpaCampos()
            return false
        }
        if (senha.isEmpty()) {
            mensagem = getString(R.string.alerta_erro_senha_obrigatoria)
            limpaCampos()
            return false
        }

        try{
            val num:Double = parseDouble(usuario)

        } catch (e:NumberFormatException){
            numeric = false
        }

        if(numeric && isCpf(usuario)) {
            mensagem = getString(R.string.alerta_erro_credencial_valido)
            limpaCampos()
            return false
        }
        if(!numeric && isEmail(usuario)){
            mensagem = getString(R.string.alerta_erro_credencial_valido)
            limpaCampos()
            return false
        }


        return true
    }

    private fun limpaCampos(){
        et_nome.setText("")
        et_senha.setText("")
        et_nome.requestFocus()
    }

    fun chamadaLogin(){


        val bankApi = RestClient.getClient().create(Api::class.java)
        val loginCall = bankApi.loginUser("test_user", "Test@1")

        loginCall.enqueue(object : Callback<UserAccount> {

            override fun onFailure(call: Call<UserAccount>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<UserAccount>, response: Response<UserAccount>) {
                val result = response.body()
                Toast.makeText(applicationContext, "==VAI CURINTIA!!!", Toast.LENGTH_LONG).show()
                var intent = Intent(context, ContaActivity::class.java)
                //intent.putExtra("teste", result?.userId)
                startActivity(intent)
                /* if(result!!.error!=null && !result!!.error!!.code.isEmpty()){
                    Toast.makeText(context, result!!.error!!.message, Toast.LENGTH_SHORT).show()
                    context.showMessage(result!!.error!!.message)
                }
                else{
                    storeUserData(user, password)
                    var intent = Intent(context, CurrencyActivity::class.java)
                    intent.putExtra(Constants.USER_ACCOUNT, result.userAccount)
                    startActivity(intent)

                }*/
            }
        }
        )
    }


}
