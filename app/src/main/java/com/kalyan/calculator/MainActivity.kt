package com.kalyan.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kalyan.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorScreen()
                }
            }
        }
    }
}

@Composable
fun CalculatorScreen() {
    var input1 by remember { mutableStateOf("") }
    var input2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = input1,
            onValueChange = { input1 = it },
            label = { Text("Enter first number") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = input2,
            onValueChange = { input2 = it },
            label = { Text("Enter second number") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = {
                result = ((input1.toDoubleOrNull() ?: 0.0) + (input2.toDoubleOrNull() ?: 0.0)).toString()
            }) {
                Text("+")
            }
            Button(onClick = {
                result = ((input1.toDoubleOrNull() ?: 0.0) - (input2.toDoubleOrNull() ?: 0.0)).toString()
            }) {
                Text("-")
            }
            Button(onClick = {
                result = ((input1.toDoubleOrNull() ?: 0.0) * (input2.toDoubleOrNull() ?: 0.0)).toString()
            }) {
                Text("×")
            }
            Button(onClick = {
                result = if ((input2.toDoubleOrNull() ?: 0.0) != 0.0)
                    ((input1.toDoubleOrNull() ?: 0.0) / (input2.toDoubleOrNull() ?: 1.0)).toString()
                else
                    "Cannot divide by 0"
            }) {
                Text("÷")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Result: $result",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}
