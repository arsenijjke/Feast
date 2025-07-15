package com.example.data.repository.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.example.data.repository.model.UserPreference
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class UserPreferencesSerializer @Inject constructor() : Serializer<UserPreference> {

    override val defaultValue = UserPreference.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserPreference {
        try {
            return Json.decodeFromString(
                UserPreference.serializer(), input.readBytes().decodeToString()
            )
        } catch (serialization: SerializationException) {
            throw CorruptionException("Unable to read UserPrefs", serialization)
        }
    }

    override suspend fun writeTo(t: UserPreference, output: OutputStream) {
        output.write(
            Json.encodeToString(UserPreference.serializer(), t)
                .encodeToByteArray()
        )
    }
}