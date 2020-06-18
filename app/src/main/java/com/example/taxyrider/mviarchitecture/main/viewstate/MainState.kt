package com.example.taxyrider.mviarchitecture.main.viewstate

import com.example.taxyrider.mviarchitecture.data.model.User

sealed class MainState {
    object Idle : MainState()
    object Loading : MainState()
    data class Users(val users : List<User>): MainState()
    data class Error(val error: String?) : MainState()
}