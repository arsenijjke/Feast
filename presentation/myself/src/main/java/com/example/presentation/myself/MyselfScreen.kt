package com.example.presentation.myself

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyselfScreen() {

}

//@ExperimentalMaterial3Api
//@Composable
//fun Myself(
//    modifier: Modifier = Modifier,
//    sheetContent: @Composable (() -> Unit)? = null,
//) {
//    val scaffoldState = rememberBottomSheetScaffoldState()
//    BottomSheetScaffold(
//        modifier = modifier,
//        scaffoldState = scaffoldState,
//        sheetContent = {
//            sheetContent
//        },
//    )
//}

@Composable
fun UserProfileScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier.padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            UserInputText(
                modifier = Modifier
                    .weight(2f),
                labelText = "Name",
                value = "Someone's name",
                onValueChange = {}
            )

            UserInputText(
                modifier = Modifier.weight(1f),
                labelText = "Gender",
                value = "G",
                onValueChange = {}
            )
        }

        Spacer(modifier.height(10.dp))

        Row(
            modifier = modifier.padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            UserInputText(
                modifier = Modifier.weight(1f),
                labelText = "Age",
                value = "",
                onValueChange = {}
            )

            UserInputText(
                modifier = Modifier.weight(1f),
                labelText = "Weight",
                value = "A",
                onValueChange = {}
            )

            UserInputText(
                modifier = Modifier.weight(1f),
                labelText = "Height",
                value = "N",
                onValueChange = {}
            )
        }
    }
}

@Composable
fun UserInputText(
    modifier: Modifier = Modifier,
    labelText: String,
    onValueChange: (String) -> Unit,
    value: String,
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = labelText) },
        singleLine = true,
    )
}

@Composable
@Preview
fun UserProfileScreenPreview() {
    UserProfileScreen()
}

@Composable
@Preview
fun MyselfPreview() {
    UserInputText(
        labelText = "Name",
        onValueChange = {},
        value = "RealNameValue"
    )
}
