package com.basakyardim.sportsbettingapp.presentation.odds_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basakyardim.sportsbettingapp.domain.use_case.OddsUseCase
import com.basakyardim.sportsbettingapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OddsViewModel @Inject constructor(
    private val oddsUseCase: OddsUseCase,
    private val savedStateHandle: SavedStateHandle

) : ViewModel() {

    private val _state = mutableStateOf(OddsState())
    val state: State<OddsState> = _state

    init {
        viewModelScope.launch {
            val sportKey = savedStateHandle.get<String>("key") ?: return@launch
            getOdds(sportKey, "us")
        }
    }

    private fun getOdds(sport: String, region: String) {
        oddsUseCase.invoke(sport, region).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = OddsState(odds = result.data ?: emptyList())

                }
                is Resource.Error -> {
                    _state.value = OddsState(
                        error = result.message ?: "An unexpected error occurred."
                    )
                }
                is Resource.Loading -> {
                    _state.value = OddsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}
