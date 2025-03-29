package com.mathislaurent.domain.repository

import kotlinx.coroutines.flow.Flow

interface OnBoardingRepository {
    fun shouldShowOnBoarding(): Flow<Boolean>
    suspend fun setShowOnBoarding(showOnBoarding: Boolean)
}