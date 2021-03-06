package com.example.taxyrider.mviarchitecture.main.viewmodel

import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taxyrider.mviarchitecture.data.repository.MainRepository
import com.example.taxyrider.mviarchitecture.main.intent.MainIntent
import com.example.taxyrider.mviarchitecture.main.viewstate.MainState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.lang.Exception

@ExperimentalCoroutinesApi
class MainViewModel (private val repository: MainRepository) : ViewModel(){

    var userIntent = Channel<MainIntent>()
    private val _state = MutableStateFlow<MainState>(MainState.Idle)
    val state : StateFlow<MainState>
          get() = _state

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect {
                when(it){
                    is MainIntent.FetchUser -> fetchUser()
                }
            }
        }
    }

    private fun fetchUser() {

        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                MainState.Users(repository.getUsers())
            }catch (e : Exception){
                MainState.Error(e.localizedMessage)
            }
        }
    }
}