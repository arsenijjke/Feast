package navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import kotlinx.serialization.Serializable

@Serializable
data object HomeScreen: NavigationElement()

@Serializable
data object SecondScreen: NavigationElement()

@Composable
fun NavigationRoot(
    modifier: Modifier,
) {
    val navController = rememberNavBackStack()
    NavDisplay (

    ) {

    }
}