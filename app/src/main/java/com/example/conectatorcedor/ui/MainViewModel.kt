package com.example.conectatorcedor.ui

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

data class AlertaProximo(val name: String, var localizacao: String)

private fun getAlertasProximos() = List(30) { i ->
    AlertaProximo(name = "Local $i", localizacao = "Carregando localizacao...")
}

class MainViewModel: ViewModel() {
    val alertasProximos = getAlertasProximos().toMutableStateList()

    fun remove(alerta : AlertaProximo) {
        alertasProximos.remove(alerta)
    }

    fun add(alerta : String) {
        alertasProximos.add(AlertaProximo(alerta, "Carregando localizacao..."))
    }
}