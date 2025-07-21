package com.example.presentation.myself

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.domain.model.UserProfile
import com.example.presentation.myself.UserProfileUiState.Success
import com.example.presentation.myself.UserProfileUiState.Loading

@Composable
fun UserProfile(
    viewModel: UserProfileViewModel
) {
    val state by viewModel.userProfileState.collectAsStateWithLifecycle()
    UserProfile(
        state = state,

    )
}

@Composable
internal fun UserProfile(
    modifier: Modifier = Modifier,
    state: UserProfileUiState,
) {
    when(state) {
        Loading -> {

        }

        is Success -> {
            UserInputs(
                profile = state.profile,
                saveProfile = TODO("Make saveable profile")
                )
        }
    }

}

@Composable
internal fun UserInputs(
    modifier: Modifier = Modifier,
    profile: UserProfile,
    saveProfile: () -> Unit,
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
                value = profile.name!!,
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
                value = profile.age!!.toString(),
                onValueChange = {}
            )

            UserInputText(
                modifier = Modifier.weight(1f),
                labelText = "Weight",
                value = profile.weight!!.toString(),
                onValueChange = {}
            )

            UserInputText(
                modifier = Modifier.weight(1f),
                labelText = "Height",
                value = profile.height!!.toString(),
                onValueChange = {}
            )
        }

        SaveInfoButton(
            onClick = { saveProfile() },
        )
    }
}

@Composable
internal fun UserInputText(
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
internal fun SaveInfoButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(),
        content = { Text("Save Info") },
        onClick = { onClick() }
    )
}

//@Composable
//@Preview
//fun UserProfileScreenPreview() {
//    UserProfileScreen(
//
//    )
//}

@Composable
@Preview
fun MyselfPreview() {
    UserInputText(
        labelText = "Name",
        onValueChange = {},
        value = "RealNameValue"
    )
}
