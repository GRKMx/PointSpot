package com.gorkemersizer.pointspot.presentation

import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties
import com.gorkemersizer.pointspot.domain.model.Spot

data class MapState(
    val properties: MapProperties = MapProperties(),
    val spots: List<Spot> = emptyList(),
    val isFallout: Boolean = false
)
