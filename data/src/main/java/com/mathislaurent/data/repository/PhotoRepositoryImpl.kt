package com.mathislaurent.data.repository

import com.mathislaurent.domain.entity.RankPhoto
import com.mathislaurent.domain.entity.RatePhoto
import com.mathislaurent.domain.repository.PhotoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PhotoRepositoryImpl(
    private val dispatcher: CoroutineDispatcher
): PhotoRepository {
    override fun getPhotoToRate(): Flow<List<RatePhoto>> = flow {
        emit(generateListPhotoRate())
    }.flowOn(dispatcher)

    override fun getRankedPhotos(): Flow<List<RankPhoto>> = flow {
        emit(generateListRankedPhotos())
    }.flowOn(dispatcher)

    private fun generateListPhotoRate(): List<RatePhoto> {
        val nbPhotosToRate = 10
        val list = mutableListOf<RatePhoto>()
        for (i in 0..nbPhotosToRate) {
            list.add(
                RatePhoto(
                    url = "https://picsum.photos/900/1600"
                )
            )
        }
        return list
    }

    private fun generateListRankedPhotos(): List<RankPhoto> {
        val nbRankedPhotos = 10
        val list = mutableListOf<RankPhoto>()
        for (i in 0..nbRankedPhotos) {
            list.add(
                RankPhoto(
                    url = "https://picsum.photos/900/1600",
                    rank = i + 1,
                    ownerName = "User n°$i"
                )
            )
        }
        return list
    }
}