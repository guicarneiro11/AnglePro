package com.guicarneirodev.goniometro.domain.repository

import com.guicarneirodev.goniometro.domain.model.Language
import com.guicarneirodev.goniometro.domain.model.UserPreferences
import com.guicarneirodev.goniometro.domain.model.UserType

interface UserPreferencesRepository {
    suspend fun getUserPreferences(): UserPreferences
    suspend fun saveUserPreferences(preferences: UserPreferences)
    suspend fun updateLanguage(language: Language)
    suspend fun updateUserType(userType: UserType)
}