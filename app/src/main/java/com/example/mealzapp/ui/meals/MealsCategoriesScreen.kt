package com.example.mealzapp.ui.meals

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.mealzapp.model.response.MealResponse
import com.example.mealzapp.ui.theme.MealzAppTheme


@Composable
fun MealsCategoriesScreen(navigationCallback: (String) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.LightGray
    ) {
        val viewModel: MealsCategoriesViewModel = viewModel()
        val meals = viewModel.mealsState.value

        LazyColumn {
            items(meals) {meal ->
                MealCategory( meal, navigationCallback )
            }
        }
    }
}

@Composable
fun MealCategory(meal: MealResponse, navigationCallback: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
            .clickable {
                navigationCallback(meal.id)
            },
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(4.dp)
        ) {
            CategoryImage(imageUrl = meal.imageUrl)
            CategoryContent(name = meal.name, description = meal.description)

        }
    }
}

@Composable
fun CategoryContent(name: String, description: String?) {
    var isExpanded by remember{ mutableStateOf(false)}
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp)
        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(end = 24.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                name,
                style = MaterialTheme.typography.h6
            )
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = description.orEmpty(),
                    maxLines = if (isExpanded) 10 else 2,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
        Box(
            modifier = Modifier
                .height(50.dp)
                .padding(start = 4.dp),
            contentAlignment = Alignment.CenterEnd
        ){
            Icon(
                imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = "Expand list",
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { isExpanded = !isExpanded }
            )
        }

    }
}

@Composable
fun CategoryImage(imageUrl: String) {
    Card(
        shape = RectangleShape,
        modifier = Modifier.padding(top = 4.dp)
    ) {
        Image(
            painter = rememberImagePainter(data = imageUrl),
            contentDescription = "Category picture",
            modifier = Modifier
                .size(88.dp)
                .padding(16.dp),
            alignment = Alignment.Center
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealsCategoriesScreen({ })
    }
}
