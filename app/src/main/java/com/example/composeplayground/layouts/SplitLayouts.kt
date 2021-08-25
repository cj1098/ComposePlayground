package com.example.composeplayground.layouts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

enum class Direction {
    START,
    END
}

@Composable
fun SplitRow(modifier: Modifier, composables: List<@Composable () -> Unit>) {
    Layout(modifier = modifier, content = { composables.forEach {
        it()
    } }, measurePolicy = { measurables, constraints ->
        val placeables = measurables.map {
            val placeable = it.measure(constraints)
            placeable
        }
        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables[0].placeRelative(0, 0)
            placeables[1].placeRelative(constraints.maxWidth - placeables[1].width, 0)
        }
    })
}