package com.example.bankapp

import android.content.Context
import android.widget.Toast

//Mensagens validação
fun Context.exibirMensagem(mensagem: String?) {
    Toast.makeText(
        this,
        mensagem,
        Toast.LENGTH_SHORT
    ).show()
}

// Valida Cpf
fun isCpf(cpf : String) : Boolean{
    val cpfClean = cpf.replace(".", "").replace("-", "")

    //## check se o tamanho é 11
    if (cpfClean.length != 11)
        return false

    //## check se é numero
    try {
        val number  = cpfClean.toLong()
    }catch (e : Exception){
        return false
    }

    //continue
    var dvCurrent10 = cpfClean.substring(9,10).toInt()
    var dvCurrent11= cpfClean.substring(10,11).toInt()


    // A soma dos nove primeiros digitos determina o decimo digito
    val cpfNineFirst = IntArray(9)
    var i = 9
    while (i > 0 ) {
        cpfNineFirst[i-1] = cpfClean.substring(i-1, i).toInt()
        i--
    }

    //Multiplica o nono digito para os tamanhos: 10,9..2
    var sumProductNine = IntArray(9)
    var weight = 10
    var position = 0
    while (weight >= 2){
        sumProductNine[position] = weight * cpfNineFirst[position]
        weight--
        position++
    }

    // Verifica o nono digito
    var dvForTenthDigit = sumProductNine.sum() % 11
    dvForTenthDigit = 11 - dvForTenthDigit //rule for tenth digit
    if(dvForTenthDigit > 9)
        dvForTenthDigit = 0
    if (dvForTenthDigit != dvCurrent10)
        return false

    // verifica o decimo digito
    var cpfTenFirst = cpfNineFirst.copyOf(10)
    cpfTenFirst[9] = dvCurrent10

    //multiple the nine digits for your weights: 10,9..2
    var sumProductTen = IntArray(10)
    var w = 11
    var p = 0
    while (w >= 2){
        sumProductTen[p] = w * cpfTenFirst[p]
        w--
        p++
    }
    //Verify the nineth digit
    var dvForeleventhDigit = sumProductTen.sum() % 11
    dvForeleventhDigit = 11 - dvForeleventhDigit
    //rule for tenth digit
    if(dvForeleventhDigit > 9)
        dvForeleventhDigit = 0
    if (dvForeleventhDigit != dvCurrent11)
        return false

    return true
}

//Valida E-mail
fun isEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}




