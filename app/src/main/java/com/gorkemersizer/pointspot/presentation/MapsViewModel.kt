package com.gorkemersizer.pointspot.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.MapStyleOptions
import com.gorkemersizer.pointspot.domain.model.Spot
import com.gorkemersizer.pointspot.domain.repository.SpotRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val repository: SpotRepository
): ViewModel() {

    var state by mutableStateOf(MapState())

    init {
        viewModelScope.launch {
            repository.getSpots().collectLatest { spots ->
                state = state.copy(
                    spots = spots
                )
            }
        }
    }

    fun onEvent(event: MapEvent) {
        when(event) {
            is MapEvent.ToggleFalloutMap -> {
                state = state.copy(
                    properties = state.properties.copy(
                        mapStyleOptions = if(state.isFallout) {
                            null
                        } else MapStyleOptions(MapStyle.json),
                    ),
                    isFallout = !state.isFallout
                )
            }
            is MapEvent.OnMapLongClick -> {
                viewModelScope.launch {
                    repository.insertSpot(Spot(
                        event.latLng.latitude,
                        event.latLng.longitude
                    )
                    )
                }
            }
            is MapEvent.OnInfoWindowLongClick -> {
                viewModelScope.launch {
                    repository.deleteSpot(event.spot)
                }
            }
        }
    }

}