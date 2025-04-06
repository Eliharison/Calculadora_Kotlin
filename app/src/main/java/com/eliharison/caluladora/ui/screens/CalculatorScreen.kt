package com.eliharison.caluladora.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eliharison.caluladora.ui.components.*
import com.eliharison.caluladora.ui.theme.CaluladoraTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {
    var primary_input by remember { mutableStateOf("") }
    var second_input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }
    var operator by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Calculadora", style = MaterialTheme.typography.headlineSmall)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        Column(
            modifier = modifier
                .padding(padding)
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Input(value = primary_input, onValueChange = { primary_input = it }, label = "Digite o 1º valor")
            Input(value = second_input, onValueChange = { second_input = it }, label = "Digite o 2º valor")
            OperatorRow(selectedOperator = operator, onOperatorSelected = { operator = it })
            ResultDisplay(value = output)

            Button(
                onClick = {
                    output = performCalculation(primary_input, second_input, operator)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = MaterialTheme.shapes.large,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("Calcular", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onPrimary)
            }

            OutlinedButton(
                onClick = {
                    primary_input = ""
                    second_input = ""
                    output = ""
                    operator = ""
                },
                modifier = modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = MaterialTheme.shapes.large
            ) {
                Text("Limpar", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CaluladoraTheme {
        CalculatorScreen()
    }
}
