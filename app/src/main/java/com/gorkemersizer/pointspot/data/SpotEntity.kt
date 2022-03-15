package com.gorkemersizer.pointspot.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SpotEntity(
    val lat: Double,
    val lng: Double,
    @PrimaryKey val id: Int? = null
)
