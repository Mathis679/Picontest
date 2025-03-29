package com.mathislaurent.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.mathislaurent.domain.repository.OnBoardingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class OnBoardingRepositoryImpl(
    private val dataStore: DataStore<Preferences>,
    private val dispatcher: CoroutineDispatcher
): OnBoardingRepository {

    private val showOnBoardingKey = booleanPreferencesKey(SHOW_ONBOARDING_PREF)

    override fun shouldShowOnBoarding(): Flow<Boolean> = dataStore.data
        .map { prefs ->
            prefs[showOnBoardingKey] ?: true
        }
        .flowOn(dispatcher)

    override suspend fun setShowOnBoarding(showOnBoarding: Boolean) {
        dataStore.edit { prefs ->
            prefs[showOnBoardingKey] = showOnBoarding
        }
    }

    companion object {
        const val SHOW_ONBOARDING_PREF = "SHOW_ONBOARDING_PREF"
    }
}