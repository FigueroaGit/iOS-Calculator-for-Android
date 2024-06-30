package com.figueroa.ioscalculator.util

import androidx.compose.runtime.MutableState
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

fun updateDisplayText(currentText: String, newInput: String): String {
    return when {
        currentText == "0" && newInput != "." -> newInput
        newInput == "." && currentText.contains(".") -> currentText // Evitar múltiples puntos decimales
        newInput == "." && currentText.isEmpty() -> "0." // Manejar punto decimal al inicio
        else -> currentText + newInput
    }
}

fun formatNumberWithCommas(number: String): String {
    return try {
        val parts = number.split(".")
        val integerPart = parts[0].replace(",", "")
        val decimalPart = if (parts.size > 1) parts[1] else ""

        val decimalFormat = DecimalFormat("#,###")
        val symbols = DecimalFormatSymbols()
        symbols.groupingSeparator = ','
        decimalFormat.decimalFormatSymbols = symbols

        val formattedIntegerPart = decimalFormat.format(integerPart.toLong())

        if (decimalPart.isEmpty()) {
            formattedIntegerPart
        } else {
            "$formattedIntegerPart.$decimalPart"
        }
    } catch (e: NumberFormatException) {
        number
    }
}

fun calculateTextSize(displayText: String): TextUnit {
    return when (displayText.length) {
        in 0..10 -> 56.sp
        in 11..20 -> 32.sp
        in 21..30 -> 28.sp
        else -> 20.sp
    }
}

fun deleteLastDigit(currentText: String): String {
    return if (currentText.length > 1) {
        currentText.dropLast(1)
    } else {
        "0"
    }
}

fun toggleSign(currentText: String): String {
    return if (currentText.isNotEmpty() && currentText != "0") {
        if (currentText.startsWith("(-")) {
            // Elimina el signo negativo y elimina los paréntesis si están presentes
            currentText.removePrefix("-").removeSurrounding("(-", ")")
        } else {
            // Agrega paréntesis alrededor del número
            "(-${currentText})"
        }
    } else {
        currentText
    }
}

fun handleOperation(
    primaryText: MutableState<String>,
    currentOperation: MutableState<String>,
    operation: MutableState<String?>,
    newOperation: String
) {
    if (currentOperation.value.isEmpty()) {
        currentOperation.value = primaryText.value + " " + newOperation + " "
        primaryText.value = "0"
    } else {
        currentOperation.value += primaryText.value + " " + newOperation + " "
        primaryText.value = "0"
    }
    operation.value = newOperation
}

fun calculateResult(operation: String): String {
    try {
        val result = operation.split("/").map { it.toFloatOrNull() ?: return "Error" }
            .reduce { acc, num -> acc / num }
        return result.toString()
    } catch (e: Exception) {
        return "Error"
    }
}