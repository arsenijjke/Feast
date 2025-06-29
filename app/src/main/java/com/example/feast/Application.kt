package com.example.feast

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.feast.navigation.root.NavigationRoot

@Composable
internal fun Application(
    modifier: Modifier
) {
    NavigationRoot(modifier)
}