package com.figueroa.ioscalculator.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.figueroa.ioscalculator.R
import com.figueroa.ioscalculator.components.BasicCalculatorButton
import com.figueroa.ioscalculator.components.BasicCalculatorScreen
import com.figueroa.ioscalculator.data.CalculatorButtonDataProvider
import com.figueroa.ioscalculator.util.calculateResult
import com.figueroa.ioscalculator.util.deleteLastDigit
import com.figueroa.ioscalculator.util.handleOperation
import com.figueroa.ioscalculator.util.toggleSign
import com.figueroa.ioscalculator.util.updateDisplayText

@Composable
fun BasicCalculator() {

    val primaryText = remember { mutableStateOf("0") }
    val secondaryText = remember { mutableStateOf("") }
    val currentOperation = remember { mutableStateOf<String>("") }
    val isBackspace = remember { mutableStateOf(false) }
    val baseValue = remember { mutableStateOf<String>("") }
    val currentValue = remember { mutableStateOf<String>("") }
    val operation = remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BasicCalculatorScreen(primaryText.value, secondaryText.value)
        Spacer(modifier = Modifier.padding(4.dp))

        CalculatorButtonDataProvider.buttonData.forEach { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                row.forEach { button ->
                    BasicCalculatorButton(
                        number = if (button.number == "AC") {
                            if (isBackspace.value) "⌫" else "AC"
                        } else button.number,
                        icon = button.icon,
                        buttonColor = button.buttonColor,
                        isIcon = button.isIcon,
                        onClick = {
                            when {
                                button.icon == R.drawable.plus_minus_icon -> {
                                    primaryText.value = toggleSign(primaryText.value)
                                }

                                button.icon == R.drawable.percent_icon -> {
                                    primaryText.value =
                                        updateDisplayText(primaryText.value, "%")
                                }

                                button.icon == R.drawable.division_icon -> {
                                    primaryText.value =
                                        updateDisplayText(primaryText.value, "÷")
                                }

                                button.icon == R.drawable.multiply_icon -> {
                                    primaryText.value =
                                        updateDisplayText(primaryText.value, "×")
                                }

                                button.icon == R.drawable.minus_icon -> {
                                    primaryText.value =
                                        updateDisplayText(primaryText.value, "-")
                                }

                                button.icon == R.drawable.plus_icon -> {
                                    primaryText.value =
                                        updateDisplayText(primaryText.value, "+")
                                }

                                button.icon == R.drawable.equals_icon -> {
                                    val result =
                                        calculateResult(currentOperation.value + primaryText.value)
                                    secondaryText.value = primaryText.value
                                    primaryText.value = result
                                    currentOperation.value = ""
                                }

                                button.number == "AC" -> {
                                    if (secondaryText.value.isNotEmpty()) {
                                        isBackspace.value = false
                                        primaryText.value = "0"
                                        secondaryText.value = ""
                                        currentOperation.value = ""
                                    } else {
                                        primaryText.value = deleteLastDigit(primaryText.value)
                                        if (primaryText.value != "0") {
                                            isBackspace.value = true

                                        }else {
                                            isBackspace.value = false
                                        }
                                    }
                                }

                                button.number != null -> {
                                    isBackspace.value = true
                                    primaryText.value =
                                        updateDisplayText(primaryText.value, button.number)
                                }
                            }
                        },
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewBasicCalculator() {
    BasicCalculator()
}