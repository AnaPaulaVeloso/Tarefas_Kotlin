package com.example.tarefas.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tarefas.R
import com.example.tarefas.adapter.TarefaAdapter
import com.example.tarefas.model.Tarefa

private lateinit var tarefaAdapter: TarefaAdapter
private lateinit var edtNomeTarefa: EditText
private lateinit var edtDescricaoTarefa: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNomeTarefa = findViewById(R.id.edt_nome_tarefa)
        edtDescricaoTarefa = findViewById(R.id.edt_descricao_tarefa)
        val btnAdicionarTarefa = findViewById<Button>(R.id.btn_adicionar_tarefa)
        val recyclerViewTarefas = findViewById<RecyclerView>(R.id.recyclerViewTarefas)

        val listaTarefas = mutableListOf<Tarefa>()

        tarefaAdapter = TarefaAdapter(listaTarefas) { tarefa ->
            tarefa.concluida = true
            tarefaAdapter.notifyDataSetChanged()
        }

        recyclerViewTarefas.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = tarefaAdapter
        }

        btnAdicionarTarefa.setOnClickListener {
            val nomeTarefa = edtNomeTarefa.text.toString()
            val descricaoTarefa = edtDescricaoTarefa.text.toString()

            if (nomeTarefa.isNotEmpty() && descricaoTarefa.isNotEmpty()) {
                val novaTarefa = Tarefa(nomeTarefa, descricaoTarefa)
                tarefaAdapter.adicionarTarefa(novaTarefa)
                edtNomeTarefa.text.clear()
                edtDescricaoTarefa.text.clear()
            }
        }
    }
}