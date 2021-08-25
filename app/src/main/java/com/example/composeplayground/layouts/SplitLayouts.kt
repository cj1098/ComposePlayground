package com.example.composeplayground.layouts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

enum class Direction {
    START,
    MIDDLE, // TODO?
    END
}

data class SplitRowLayoutComposable(val direction: Direction, val composable: @Composable () -> Unit)

@Composable
fun SplitRow(modifier: Modifier, composables: List<SplitRowLayoutComposable>) {
    Layout(modifier = modifier, content = { composables.forEach {
        it.composable()
    } }, measurePolicy = { measurables, constraints ->
        val placeables = measurables.mapIndexed { index, measureable ->
            Pair(measureable.measure(constraints.copy(minWidth = 0, minHeight = 0)), composables[index].direction)
        }
        // TODO: If all placeables can't fit on screen (too wide) then log it.
        layout(constraints.maxWidth, constraints.maxHeight) {
            var startX = 0
            var endX = constraints.maxWidth
            placeables.forEach {
                when (it.second) {
                    Direction.START -> {
                        if (startX + it.first.width < endX) {
                            it.first.placeRelative(startX, 0)
                            startX += it.first.width
                        }
                    }
                    Direction.END -> {
                        if (endX - it.first.width > startX) {
                            endX -= it.first.width
                            it.first.placeRelative(endX, 0)
                        }
                    }
                }
            }
        }
    })
}

@Composable
fun SplitColumn(modifier: Modifier, composables: List<SplitRowLayoutComposable>) {
    Layout(modifier = modifier, content = { composables.forEach {
        it.composable()
    } }, measurePolicy = { measurables, constraints ->
        val placeables = measurables.mapIndexed { index, measureable ->
            Pair(measureable.measure(constraints.copy(minWidth = 0, minHeight = 0)), composables[index].direction)
        }
        // TODO: If all placeables can't fit on screen (too wide) then log it.
        layout(constraints.maxWidth, constraints.maxHeight) {
            var startY = 0
            var endY = constraints.maxHeight
            placeables.forEach {
                when (it.second) {
                    Direction.START -> {
                        if (startY + it.first.height < endY) {
                            it.first.placeRelative(0, startY)
                            startY += it.first.height
                        }
                    }
                    Direction.END -> {
                        if (endY - it.first.height > startY) {
                            endY -= it.first.height
                            it.first.placeRelative(0, endY)
                        }
                    }
                }
            }
        }
    })
}