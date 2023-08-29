package com.alternova.printtps900.print

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PrintScreen(onLaunchPrint: (String) -> Unit) {
    val text = remember { mutableStateOf("This is print") }
    val onPrint: () -> Unit = {
        onLaunchPrint(text.value)
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        title()
        textField(text = text)
        button(onPrint, isEnable = text.value.isNotEmpty())
    }
}

private fun LazyListScope.title() {
    item {
        Text(text = "This is a APP print TPS900", style = MaterialTheme.typography.headlineMedium)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
private fun LazyListScope.textField(text: MutableState<String>) {
    item {
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(text = "Type text!", style = MaterialTheme.typography.labelLarge)
            OutlinedTextField(
                value = text.value,
                onValueChange = { text.value = it },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

private fun LazyListScope.button(onPrint: () -> Unit, isEnable: Boolean) {
    item {
        Button(onClick = onPrint, enabled = isEnable, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Print")
        }
    }
}