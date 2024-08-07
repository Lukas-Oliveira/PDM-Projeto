package com.example.conectatorcedor.ui

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.conectatorcedor.R
import com.example.conectatorcedor.RegisterActivity

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun LoginPage(
    modifier: Modifier = Modifier
) {
    var email by rememberSaveable { mutableStateOf(value="") }
    var password by rememberSaveable { mutableStateOf(value="") }
    var activity = LocalContext.current as? Activity

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Conecta Torcedor Logo",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(50.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "E-Mail") },
            modifier = modifier.size(width = 325.dp, height = 50.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Senha") },
            modifier = modifier.size(width = 325.dp, height = 50.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A8FDD)),
            modifier = modifier.size(width = 175.dp, height = 40.dp)
        ) {
            Text(text = "ENTRAR")    
        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = {
                activity?.startActivity(
                    Intent(activity, RegisterActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                )
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A8FDD)),
            modifier = modifier.size(width = 175.dp, height = 40.dp)
        ) {
            Text(text = "REGISTRAR")
        }
    }
}
