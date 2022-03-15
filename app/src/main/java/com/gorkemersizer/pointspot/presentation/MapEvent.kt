package com.gorkemersizer.pointspot.presentation

import com.google.android.gms.maps.model.LatLng
import com.gorkemersizer.pointspot.domain.model.Spot

sealed class MapEvent {
    object ToggleFalloutMap: MapEvent()
    data class OnMapLongClick(val latLng: LatLng):  MapEvent()
    data class OnInfoWindowLongClick(val spot: Spot): MapEvent()
}
