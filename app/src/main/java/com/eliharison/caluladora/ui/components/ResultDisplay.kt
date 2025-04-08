package com.eliharison.caluladora.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResultDisplay(value: String) {
    OutlinedTextField(
        value = value,
        onValueChange = {},
        label = { Text("Resultado", style = MaterialTheme.typography.bodyLarge) },
        readOnly = true,
        modifier = Modifier.fillMaxWidth()
            .height(85.dp),
        shape = MaterialTheme.shapes.large,
        singleLine = true
    )
}

fun performCalculation(
    primary_input: String,
    second_input: String,
    operator: String
): String {
    if (primary_input.isBlank() || second_input.isBlank()) {
        return "Preencha ambos os valores"
    }
    val primary_input = primary_input.toDoubleOrNull()
    val second_input = second_input.toDoubleOrNull()

    if (primary_input == null || second_input == null) {
        return "Entrada inválida: insira números válidos"
    }

    if (operator.isBlank()) {
        return "Selecione um operador"
    }

    if (operator == "/" && second_input == 0.0) {
        return "Não é possível dividir por zero"
    }

    val result = when (operator) {
        "+" -> primary_input + second_input
        "-" -> primary_input - second_input
        "*" -> primary_input * second_input
        "/" -> primary_input / second_input
        else -> return "Operador inválido"
    }

    if (result.isNaN() || result.isInfinite()) {
        return "Erro no cálculo"
    }

    return result.toString()
}
