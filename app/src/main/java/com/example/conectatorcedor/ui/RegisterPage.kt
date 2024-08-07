package com.example.conectatorcedor.ui

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.conectatorcedor.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun RegisterPage(
    modifier: Modifier = Modifier
) {
    var name  by rememberSaveable { mutableStateOf(value="") }
    var email by rememberSaveable { mutableStateOf(value="") }

    var password by rememberSaveable { mutableStateOf(value="") }
    var passwordConfirmation by rememberSaveable { mutableStateOf(value="") }

    var interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }

    var activity = LocalContext.current as? Activity

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Conecta Torcedor Logo",
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(50.dp))

        Text(text = "Registre-se")
        Spacer(modifier = modifier.height(50.dp))
        
        DataField(value = name, onValueChange = { name = it }, label = "Nome", modifier = modifier)
        Spacer(modifier = modifier.height(30.dp))
        
        DataField(value = email, onValueChange = { email = it }, label = "E-Mail", modifier = modifier)
        Spacer(modifier = modifier.height(30.dp))

        PasswordField(value = password, onValueChange = { password = it }, label = "Senha", modifier = modifier)
        Spacer(modifier = modifier.height(30.dp))

        PasswordField(value = passwordConfirmation, onValueChange = { passwordConfirmation = it }, label = "Confirmação de Senha", modifier = modifier)
        Spacer(modifier = modifier.height(50.dp))

        Button(
            onClick  = {},
            colors   = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A8FDD)),
            modifier = modifier.size(width = 175.dp, height = 40.dp),
            enabled  = name.isNotEmpty()                 &&
                       email.isNotEmpty()                &&
                       password.isNotEmpty()             &&
                       passwordConfirmation.isNotEmpty() &&
                       password.equals(passwordConfirmation)
        ) {
            Text(text = "REGISTRAR")
        }
    }
}