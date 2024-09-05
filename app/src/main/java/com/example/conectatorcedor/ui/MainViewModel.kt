package com.example.conectatorcedor.ui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

data class AlertaProximo(val name: String, var localizacao: String)

private fun getAlertasProximos() = List(30) { i ->
    AlertaProximo(name = "Local $i", localizacao = "Carregando localizacao...")
}

class MainViewModel: ViewModel() {

    private var _loggedIn = mutableStateOf(false)
    val loggedIn: Boolean
        get() = _loggedIn.value

    private val listener = FirebaseAuth.AuthStateListener {
        firebaseAuth ->
        _loggedIn.value = firebaseAuth.currentUser != null
    }

    init {
        listener.onAuthStateChanged(Firebase.auth)
        Firebase.auth.addAuthStateListener(listener)
    }

    override fun onCleared() {
        Firebase.auth.removeAuthStateListener(listener)
    }

    val alertasProximos = getAlertasProximos().toMutableStateList()

    fun remove(alerta : AlertaProximo) {
        alertasProximos.remove(alerta)
    }

    fun add(alerta : String) {
        alertasProximos.add(AlertaProximo(alerta, "Carregando localizacao..."))
    }
}