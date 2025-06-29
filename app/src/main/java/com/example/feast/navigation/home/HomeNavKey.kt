package com.example.feast.navigation.home

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import kotlinx.serialization.Serializable

/**
 * HomeNavDisplay a NavDisplay made for feature navigation flow from single display
 */

@Serializable
data object HomeNavKey : NavKey

@Composable
fun HomeNavDisplay(
    existedBackStack: NavBackStack,
    key: NavKey
) {
    val backStack = rememberNavBackStack(existedBackStack.last())
    NavDisplay(
        backStack = backStack,
        entryProvider = {
            NavEntry(key = key) {
                HomeScreen()
            }
        }
    )
}
