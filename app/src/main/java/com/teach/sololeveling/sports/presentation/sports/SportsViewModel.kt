package com.teach.sololeveling.sports.presentation.sports

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teach.sololeveling.core.utils.Resource
import com.teach.sololeveling.sports.domain.use_case.GetSportsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SportsViewModel @Inject constructor(
    private val getSportsUseCase: GetSportsUseCase

):ViewModel() {
    private val _state = mutableStateOf(SportsListState())
    val state: State<SportsListState> = _state

    private var getsportListJob: Job? = null
    private val errorHandler = CoroutineExceptionHandler {_, e ->
        e.printStackTrace()
        _state.value = _state.value.copy(
            error = e.message,
            isLoading = false
        )
    }
    init {
        getAllSports()
    }

     fun getAllSports(){
        getSportsUseCase().onEach { result->
            when(result){
                is Resource.Error -> {
                    Log.d("state",result.message.toString())
                    _state.value=SportsListState(error = result.message, isLoading = false)

                }
                is Resource.Loading -> {
                    _state.value= SportsListState(isLoading = true)
                    Log.d("state","Loading")
                }
                is Resource.Success -> {
                    _state.value= SportsListState(sportsList = result.data ?: emptyList(),isLoading = false)
                    Log.d("state", "getAllSports: "+ result.data.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

}