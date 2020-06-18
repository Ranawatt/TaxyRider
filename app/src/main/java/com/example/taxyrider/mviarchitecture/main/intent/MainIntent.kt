package com.example.taxyrider.mviarchitecture.main.intent

sealed class MainIntent {
    object FetchUser : MainIntent()
}