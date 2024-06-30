package com.figueroa.ioscalculator.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.figueroa.ioscalculator.R
import com.figueroa.ioscalculator.components.BasicCalculatorButton
import com.figueroa.ioscalculator.components.BasicCalculatorScreen
import com.figueroa.ioscalculator.data.CalculatorButtonDataProvider
import com.figueroa.ioscalculator.model.CalculatorButtons
import com.figueroa.ioscalculator.ui.theme.BasicCalculatorButtonPrimary
import com.figueroa.ioscalculator.ui.theme.BasicCalculatorButtonSecondary
import com.figueroa.ioscalculator.ui.theme.BasicCalculatorButtonTertiary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicCalculator() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { /*TODO*/ },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.navigation_drawer_icon),
                            contentDescription = "NavigationDrawerIcon",
                            tint = BasicCalculatorButtonTertiary
                        )
                    }
                },
                colors = TopAppBarColors(
                    containerColor = Color.Black,
                    scrolledContainerColor = Color.Black,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        },
        containerColor = Color.Black
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                BasicCalculatorScreen()
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
                                number = button.number,
                                icon = button.icon,
                                buttonColor = button.buttonColor,
                                isIcon = button.isIcon
                            )
                        }
                    }
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