package com.example.mealzapp.ui.details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.mealzapp.model.response.MealResponse
import com.example.mealzapp.ui.components.appBar.AppBar

@Composable
fun MealDetailsScreen(meal: MealResponse?, navigation: NavHostController?) {

    var isExpanded by remember { mutableStateOf(false) }
    val imageSizeDp: Dp by animateDpAsState(
        targetValue =  if (isExpanded) 200.dp else 100.dp
    )
    Scaffold(
        topBar = {
            AppBar(
                title = "Category Details",
                icon = Icons.Default.ArrowBack,
            ){
              navigation?.navigateUp()
            }
        }) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column {
                Row {
                    Card(
                        modifier = Modifier
                            .padding(16.dp),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 1.dp,
                            color = Color.LightGray
                        )
                    ) {
                        Image(
                            painter = rememberImagePainter(
                                data = meal?.imageUrl,
                                builder = {
                                    transformations(CircleCropTransformation())
                                }),
                            contentDescription = null,
                            modifier = Modifier
                                .size(imageSizeDp)
                                .padding(8.dp)
                        )
                    }
                    Text(
                        text =meal?.name?: "default name",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.h6
                    )
                }
                Button(
                    onClick = {
                        isExpanded = !isExpanded
                    }) {
                    Text("Change State of meal profile picture")
                }
            }
        }
    }


}
