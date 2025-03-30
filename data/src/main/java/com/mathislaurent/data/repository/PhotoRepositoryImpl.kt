package com.mathislaurent.data.repository

import com.mathislaurent.data.datasource.remote.FakeRemotePhotoService
import com.mathislaurent.domain.entity.RankPhoto
import com.mathislaurent.domain.entity.RatePhoto
import com.mathislaurent.domain.repository.PhotoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class PhotoRepositoryImpl(
    private val dataSource: FakeRemotePhotoService,
    private val dispatcher: CoroutineDispatcher
): PhotoRepository {
    override fun getPhotoToRate(): Flow<List<RatePhoto>> {
        return dataSource
            .getPhotoToRate()
            .flowOn(dispatcher)
    }

    override fun getRankedPhotos(): Flow<List<RankPhoto>> {
        return dataSource
            .getRankedPhotos()
            .flowOn(dispatcher)
    }
}