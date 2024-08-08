package com.example.conectatorcedor.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conectatorcedor.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun IssueAlertPage(
    modifier: Modifier = Modifier
) {
    
    val description = rememberSaveable { mutableStateOf(value = "") }
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = modifier.height(50.dp))
            
            Image(
                painter = painterResource(id = R.drawable.siren),
                contentDescription = "Logo emitir alerta",
                modifier = modifier.size(20.dp)
            )
            Spacer(modifier = modifier.width(2.dp))
            Text(
                text = "Emitir Alerta",
                fontSize = 16.sp
            )
        }
        
        Spacer(modifier = modifier.height(50.dp))
        Text(
            text = "Tipo de Alerta",
            fontSize = 18.sp
        )
        Spacer(modifier = modifier.height(20.dp))
        
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                onClick = {}
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.fist),
                        contentDescription = "Icone de Brigas",
                        modifier = modifier
                            .size(width = 100.dp, height = 100.dp)
                            .border(BorderStroke(1.dp, Color.Black))
                    )
                    Spacer(modifier = modifier.height(15.dp))
                    Text(
                        text = "Briga",
                        modifier = modifier.width(100.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp
                    )
                }
            }
            Spacer(modifier = modifier.width(10.dp))
            
            Surface (
                onClick = {}
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.strike),
                        contentDescription = "Icone de Protestos",
                        modifier = modifier
                            .size(width = 100.dp, height = 100.dp)
                            .border(BorderStroke(1.dp, Color.Black)),
                    )
                    Spacer(modifier = modifier.height(15.dp))
                    Text(
                        text = "Protestos",
                        modifier = modifier.width(100.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp
                    )
                }
            }
            Spacer(modifier = modifier.width(10.dp))
            
            
            Surface(
                onClick = {}
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.people),
                        contentDescription = "Icone de Multidao",
                        modifier = modifier
                            .size(width = 100.dp, height = 100.dp)
                            .border(BorderStroke(1.dp, Color.Black))
                    )
                    Spacer(modifier = modifier.height(15.dp))
                    Text(
                        text = "Multidão",
                        modifier = modifier.width(100.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp
                    )
                }
            }
        }
        
        Spacer(modifier = modifier.height(50.dp))
        Text(
            text = "Descrição",
            fontSize = 18.sp
        )
        Spacer(modifier = modifier.height(20.dp))
        TextField(
            value = description.value,
            onValueChange = { description.value = it },
            modifier = modifier
                .width(340.dp)
                .height(250.dp)
                .padding(10.dp)
                .border(BorderStroke(1.dp, Color.Black))
        )
        Spacer(modifier = modifier.height(20.dp))
        
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.attach),
                contentDescription = "Iconde de Anexo",
                modifier = modifier.size(30.dp)
            )
            Text(
                text = "Anexos",
                fontSize = 18.sp
            )
        }
        
        Spacer(modifier = modifier.height(50.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = modifier.width(320.dp)
        ) {
            
            Text(
                text = "Selecionar Localização"
            )
        }
    }
}