package com.gorkemersizer.pointspot.data

import com.gorkemersizer.pointspot.domain.model.Spot
import com.gorkemersizer.pointspot.domain.repository.SpotRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SpotRepositoryImpl(
    private val dao: SpotDao
): SpotRepository {

    override suspend fun insertSpot(spot: Spot) {
        dao.insertSpot(spot.toSpotEntity())
    }

    override suspend fun deleteSpot(spot: Spot) {
        dao.deleteSpot(spot.toSpotEntity())
    }

    override fun getSpots(): Flow<List<Spot>> {
        return dao.getParkingSpots().map { spots ->
            spots.map { it.toSpot() }
        }
    }
}