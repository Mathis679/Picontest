package com.mathislaurent.domain.repository

import com.mathislaurent.domain.entity.RankPhoto
import com.mathislaurent.domain.entity.RatePhoto
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {
    fun getPhotoToRate(): Flow<List<RatePhoto>>
    fun getRankedPhotos(): Flow<List<RankPhoto>>
}