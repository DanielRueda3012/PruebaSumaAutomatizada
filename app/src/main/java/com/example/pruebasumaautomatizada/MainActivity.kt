package com.example.pruebasumaautomatizada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pruebasumaautomatizada.ui.theme.PruebaSumaAutomatizadaTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontStyle


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaSumaAutomatizadaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    SumaAutomatizada()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SumaAutomatizada() {
    var number1 by remember { mutableStateOf(0) }
    var number2 by remember { mutableStateOf(0) }

    val result by remember {
        derivedStateOf {
            number1 + number2
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "SUMAS AUTOMATIZADAS",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(Color(249, 228, 75)),
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )
            TextField(
                value = number1.toString(),
                onValueChange = { number1 = it.toIntOrNull() ?: 0 },
                label = { Text("Número 1") }
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = number2.toString(),
                onValueChange = { number2 = it.toIntOrNull() ?: 0 },
                label = { Text("Número 2") }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "El resultado es: $result",
                style = MaterialTheme.typography.displaySmall, //tipo de tipografia
                fontStyle= FontStyle.Italic  //para ponerlo en cursiva
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SumaAutomatizadaPreview() {
    PruebaSumaAutomatizadaTheme {
        SumaAutomatizada()
    }
}
