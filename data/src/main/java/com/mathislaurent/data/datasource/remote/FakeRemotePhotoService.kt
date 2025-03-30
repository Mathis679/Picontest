package com.mathislaurent.data.datasource.remote

import com.mathislaurent.domain.entity.RankPhoto
import com.mathislaurent.domain.entity.RatePhoto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class FakeRemotePhotoService(
    private val dispatcher: CoroutineDispatcher
) {
    fun getPhotoToRate(): Flow<List<RatePhoto>> = flow {
        delay(200)
        emit(generateListPhotoRate())
    }.flowOn(dispatcher)

    fun getRankedPhotos(): Flow<List<RankPhoto>> = flow {
        delay(200)
        emit(generateListRankedPhotos())
    }.flowOn(dispatcher)

    private fun generateListPhotoRate(): List<RatePhoto> {
        val nbPhotosToRate = 10
        val list = mutableListOf<RatePhoto>()
        for (i in 0 until nbPhotosToRate) {
            list.add(
                RatePhoto(
                    url = RANDOM_PIC_URL
                )
            )
        }
        return list
    }

    private fun generateListRankedPhotos(): List<RankPhoto> {
        val nbRankedPhotos = 10
        val list = mutableListOf<RankPhoto>()
        for (i in 0 until nbRankedPhotos) {
            list.add(
                RankPhoto(
                    url = RANDOM_PIC_URL,
                    rank = i + 1,
                    ownerName = "User n°$i"
                )
            )
        }
        return list
    }

    companion object {
        const val RANDOM_PIC_URL = "https://picsum.photos/900/1600"
    }
}