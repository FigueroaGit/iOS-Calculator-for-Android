package com.figueroa.ioscalculator.model

import androidx.compose.ui.graphics.Color

data class CalculatorButtons(
    val number: String? = null,
    val buttonColor: Color = Color.Unspecified,
    val isIcon: Boolean = false,
    val icon: Int? = null
)
