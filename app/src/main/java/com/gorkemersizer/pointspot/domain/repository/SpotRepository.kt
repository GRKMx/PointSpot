package com.gorkemersizer.pointspot.domain.repository

import com.gorkemersizer.pointspot.domain.model.Spot
import kotlinx.coroutines.flow.Flow

interface SpotRepository {

    suspend fun insertSpot(spot: Spot)

    suspend fun deleteSpot(spot: Spot)

    fun getSpots(): Flow<List<Spot>>
}