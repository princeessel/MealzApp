package com.example.mealzapp.ui.appBar

import android.service.autofill.OnClickAction
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

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
