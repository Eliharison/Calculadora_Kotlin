package com.eliharison.caluladora.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OperatorRow(selectedOperator: String, onOperatorSelected: (String) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        listOf("+", "-", "*", "/").forEach { op ->
            CalcButton(
                label = op,
                onClick = { onOperatorSelected(op) },
                isSelected = selectedOperator == op,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
