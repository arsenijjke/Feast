package com.example.feast.navigation.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.example.feast.navigation.home.HomeNavDisplay
import com.example.feast.navigation.home.HomeNavKey

/**
 * A top-level [NavigationRoot] of application.
 */
@Composable
fun NavigationRoot(
    modifier: Modifier,
) {
    val backStack = rememberNavBackStack(HomeNavKey)
    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryDecorators = listOf(
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
            rememberSceneSetupNavEntryDecorator()
        ),
        entryProvider = { key ->
            when (key) {
                is HomeNavKey -> { navEntry(key) { HomeNavDisplay(backStack, key) } }
                else -> throw RuntimeException("Invalid NavKey")
            }
        }
    )
}

inline fun <reified T : NavKey> navEntry(
    key: T,
    noinline content: @Composable (T) -> Unit
): NavEntry<T> {
    return NavEntry(
        key = key,
        content = content
    )
}
