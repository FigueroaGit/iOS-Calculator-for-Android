package com.figueroa.ioscalculator.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.figueroa.ioscalculator.R
import com.figueroa.ioscalculator.ui.theme.BasicCalculatorButtonPrimary
import com.figueroa.ioscalculator.ui.theme.TextColorPrimary
import com.figueroa.ioscalculator.ui.theme.TextColorSecondary
import com.figueroa.ioscalculator.ui.theme.sanFranciscoProFamily
import com.figueroa.ioscalculator.util.calculateTextSize

@Preview
@Composable
fun BasicCalculatorButton(
    number: String? = "AC",
    isIcon: Boolean = false,
    icon: Int? = R.drawable.plus_minus_icon,
    buttonColor: Color = BasicCalculatorButtonPrimary,
    onClick: () -> Unit = {},
) {
    Button(
        modifier = Modifier.size(88.dp), onClick = { onClick.invoke() }, colors = ButtonColors(
            containerColor = buttonColor,
            contentColor = TextColorPrimary,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        ), elevation = ButtonDefaults.buttonElevation(0.dp),
        contentPadding = ButtonDefaults.TextButtonContentPadding
    ) {
        if (isIcon) {
            icon?.let { painterResource(id = it) }?.let {
                Icon(
                    painter = it, contentDescription = null
                )
            }
        } else {
            if (number != null) {
                Text(
                    text = number,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = sanFranciscoProFamily
                )
            }
        }
    }
}

@Preview
@Composable
fun BasicCalculatorScreen(
    primaryText: String = "0",
    secondaryText: String = "",
) {

    val textSize = calculateTextSize(primaryText)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = secondaryText,
            color = TextColorSecondary,
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = sanFranciscoProFamily,
            textAlign = TextAlign.End
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = primaryText,
            color = TextColorPrimary,
            fontSize = textSize,
            fontWeight = FontWeight.Normal,
            fontFamily = sanFranciscoProFamily,
            textAlign = TextAlign.End,
            maxLines = 1
        )
    }
}
