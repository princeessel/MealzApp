package com.example.mealzapp.ui.components.appBar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mealzapp.ui.theme.MealzAppTheme

@Composable
fun AppBar(title: String, icon: ImageVector, onClickAction: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier
                    .padding(12.dp)
                    .clickable(onClick = {onClickAction.invoke()})
            )},
        title = {
            Text(text = title)
        },
    )
}

@Preview(showBackground = true)
@Composable
fun AppBarPreview() {
    MealzAppTheme {
        AppBar(title = "App Bar", icon = Icons.Default.Home) {}
    }
}
