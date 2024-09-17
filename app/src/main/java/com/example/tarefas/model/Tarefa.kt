package com.example.tarefas.model

data class Tarefa(
    val nome: String,
    val descricao: String,
    var concluida: Boolean = false
)
