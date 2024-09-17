package com.example.tarefas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tarefas.R
import com.example.tarefas.model.Tarefa

class TarefaAdapter(private var tarefas: MutableList<Tarefa>, private val marcarConcluida: (Tarefa) -> Unit) : RecyclerView.Adapter<TarefaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvNome: TextView = itemView.findViewById(R.id.txv_nome_tarefa)
        val txvDescricao: TextView = itemView.findViewById(R.id.txv_descricao_tarefa)
        val btnConcluir: Button = itemView.findViewById(R.id.btn_concluir_tarefa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefa, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarefa = tarefas[position]
        holder.txvNome.text = tarefa.nome
        holder.txvDescricao.text = tarefa.descricao
        holder.btnConcluir.text = if (tarefa.concluida) "Concluída" else "Concluir"

        holder.btnConcluir.setOnClickListener {
            marcarConcluida(tarefa)
            notifyItemChanged(position)
        }

    }

    override fun getItemCount(): Int = tarefas.size

    fun adicionarTarefa(novaTarefa: Tarefa) {
        tarefas.add(novaTarefa)
        notifyItemInserted(tarefas.size - 1)
    }
}