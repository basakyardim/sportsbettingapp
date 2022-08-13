package com.basakyardim.sportsbettingapp.presentation.bulletin_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basakyardim.sportsbettingapp.domain.use_case.SportsListUseCase
import com.basakyardim.sportsbettingapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BulletinViewModel @Inject constructor(
    private val sportsListUseCase: SportsListUseCase,
    ) : ViewModel() {

    private val _state = mutableStateOf(BulletinState())
    val state: State<BulletinState> = _state


    init {
        getSports()
    }
    private fun getSports() {
        sportsListUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = BulletinState(sports = result.data ?: emptyList())

                }
                is Resource.Error -> {
                    _state.value = BulletinState(
                        error = result.message ?: "An unexpected error occurred."
                    )
                }
                is Resource.Loading -> {
                    _state.value = BulletinState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
     
    }

}

