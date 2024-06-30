package com.figueroa.ioscalculator.data

import com.figueroa.ioscalculator.R
import com.figueroa.ioscalculator.model.CalculatorButtons
import com.figueroa.ioscalculator.ui.theme.BasicCalculatorButtonPrimary
import com.figueroa.ioscalculator.ui.theme.BasicCalculatorButtonSecondary
import com.figueroa.ioscalculator.ui.theme.BasicCalculatorButtonTertiary

object CalculatorButtonDataProvider {
    val buttonData =
        listOf(
            listOf(
                CalculatorButtons(number = "AC", buttonColor = BasicCalculatorButtonSecondary),
                CalculatorButtons(
                    icon = R.drawable.plus_minus_icon,
                    buttonColor = BasicCalculatorButtonSecondary,
                    isIcon = true
                ),
                CalculatorButtons(
                    icon = R.drawable.percent_icon,
                    buttonColor = BasicCalculatorButtonSecondary,
                    isIcon = true
                ),
                CalculatorButtons(
                    icon = R.drawable.division_icon,
                    buttonColor = BasicCalculatorButtonTertiary,
                    isIcon = true
                )
            ),
            listOf(
                CalculatorButtons(number = "7", buttonColor = BasicCalculatorButtonPrimary),
                CalculatorButtons(number = "8", buttonColor = BasicCalculatorButtonPrimary),
                CalculatorButtons(number = "9", buttonColor = BasicCalculatorButtonPrimary),
                CalculatorButtons(
                    icon = R.drawable.multiply_icon,
                    buttonColor = BasicCalculatorButtonTertiary,
                    isIcon = true
                )
            ),
            listOf(
                CalculatorButtons(number = "4", buttonColor = BasicCalculatorButtonPrimary),
                CalculatorButtons(number = "5", buttonColor = BasicCalculatorButtonPrimary),
                CalculatorButtons(number = "6", buttonColor = BasicCalculatorButtonPrimary),
                CalculatorButtons(
                    icon = R.drawable.minus_icon,
                    buttonColor = BasicCalculatorButtonTertiary,
                    isIcon = true
                )
            ),
            listOf(
                CalculatorButtons(number = "1", buttonColor = BasicCalculatorButtonPrimary),
                CalculatorButtons(number = "2", buttonColor = BasicCalculatorButtonPrimary),
                CalculatorButtons(number = "3", buttonColor = BasicCalculatorButtonPrimary),
                CalculatorButtons(
                    icon = R.drawable.plus_icon,
                    buttonColor = BasicCalculatorButtonTertiary,
                    isIcon = true
                )
            ),
            listOf(
                CalculatorButtons(
                    icon = R.drawable.calculator_type_icon,
                    buttonColor = BasicCalculatorButtonPrimary,
                    isIcon = true
                ),
                CalculatorButtons(number = "0", buttonColor = BasicCalculatorButtonPrimary),
                CalculatorButtons(number = ".", buttonColor = BasicCalculatorButtonPrimary),
                CalculatorButtons(
                    icon = R.drawable.equals_icon,
                    buttonColor = BasicCalculatorButtonTertiary,
                    isIcon = true
                )
            )
        )
}