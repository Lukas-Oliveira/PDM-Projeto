package com.example.conectatorcedor.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataField(
    value: String,
    onValueChange: (value: String) -> Unit,
    label: String,
    modifier: Modifier
) {
    var interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.size(width = 325.dp, height = 50.dp),
        singleLine = true
    ) { innerTextField ->
        TextFieldDefaults.OutlinedTextFieldDecorationBox(
            value = value,
            label = { Text(text = label) },
            innerTextField = innerTextField,
            enabled = true,
            singleLine = true,
            visualTransformation = VisualTransformation.None,
            interactionSource = interactionSource
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(
    value: String,
    onValueChange: (value: String) -> Unit,
    label: String,
    modifier: Modifier
) {
    var interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.size(width = 325.dp, height = 50.dp),
        singleLine = true,
        visualTransformation = PasswordVisualTransformation()
    ) { innerTextField ->
        TextFieldDefaults.OutlinedTextFieldDecorationBox(
            value = value,
            label = { Text(text = label) },
            innerTextField = innerTextField,
            enabled = true,
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            interactionSource = interactionSource
        )
    }
}

