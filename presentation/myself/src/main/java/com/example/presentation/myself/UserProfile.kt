package com.example.presentation.myself

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.domain.model.Gender
import com.example.domain.model.UserProfile
import com.example.presentation.myself.UserProfileUiState.Success
import com.example.presentation.myself.UserProfileUiState.Loading

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfile(
    viewModel: UserProfileViewModel
) {
    val state by viewModel.userProfileState.collectAsStateWithLifecycle()
    val scaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent =  {
            UserProfileScreen(
                state = state,
                saveProfile = { viewModel.updateProfile() },
                updateName = viewModel::updateUsername,
                updateAge = viewModel::updateAge,
                updateHeight = viewModel::updateHeight,
                updateWeight = viewModel::updateWeight,
                updateGender = viewModel::updateGender
                )
        }
    ) {

    }

}

@Composable
internal fun UserProfileScreen(
    modifier: Modifier = Modifier,
    state: UserProfileUiState,
    saveProfile: () -> Unit,
    updateName: (String) -> Unit,
    updateAge: (Int) -> Unit,
    updateWeight: (Int) -> Unit,
    updateHeight: (Int) -> Unit,
    updateGender: (Gender) -> Unit
) {
    when (state) {
        is Loading -> {

        }

        is Success -> {
            UserInputs(
                profile = state.profile,
                saveProfile = saveProfile,
                updateName = updateName,
                updateAge = updateAge,
                updateHeight = updateHeight,
                updateWeight = updateWeight,
                updateGender = updateGender
            )
        }
    }
}


@Composable
internal fun UserInputs(
    modifier: Modifier = Modifier,
    profile: UserProfile,
    saveProfile: () -> Unit,
    updateName: (String) -> Unit,
    updateAge: (Int) -> Unit,
    updateWeight: (Int) -> Unit,
    updateHeight: (Int) -> Unit,
    updateGender: (Gender) -> Unit
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
                onValueChange = updateName
            )

            UserInputText(
                modifier = Modifier.weight(1f),
                labelText = "Gender",
                value = "G",
                onValueChange = TODO("Gender validator")
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
                onValueChange = TODO("Age validator")
            )

            UserInputText(
                modifier = Modifier.weight(1f),
                labelText = "Weight",
                value = profile.weight!!.toString(),
                onValueChange = TODO("Weight validator")
            )

            UserInputText(
                modifier = Modifier.weight(1f),
                labelText = "Height",
                value = profile.height!!.toString(),
                onValueChange = TODO("Height validator")
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
    val state = rememberTextFieldState()
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { it },
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
