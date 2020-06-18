package com.example.taxyrider.mviarchitecture.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.taxyrider.mviarchitecture.data.api.ApiHelper
import com.example.taxyrider.mviarchitecture.data.repository.MainRepository
import com.example.taxyrider.mviarchitecture.main.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory (private val apiHelper: ApiHelper ): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}