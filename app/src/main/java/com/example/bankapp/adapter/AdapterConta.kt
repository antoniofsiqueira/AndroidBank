package com.example.bankapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bankapp.R
import com.example.bankapp.models.Transaction

class AdapterTransacoes(private val listTransaction: List<Transaction>) :
    RecyclerView.Adapter<AdapterTransacoes.MyViewHolder>() {

    //para exibir os dados dentro de cada elemento de lista
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var title: TextView = itemView.findViewById(R.id.txvTitle)
        internal var desc:  TextView = itemView.findViewById(R.id.txvDesc)
        internal var date:  TextView = itemView.findViewById(R.id.txvDate)
        internal var value: TextView = itemView.findViewById(R.id.txvValue)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //Pega o objeto itemLista e converte numa visualização
        val itemLista = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_conta, parent, false)

        return MyViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val transaction = listTransaction[position]

        holder.title.text = transaction.title
        holder.desc.text  = transaction.desc
        holder.date.text  = transaction.date
        holder.value.text = transaction.valor.toString()
    }

    override fun getItemCount(): Int {
        return listTransaction.size
    }
}