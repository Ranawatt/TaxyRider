package com.example.taxyrider.mviarchitecture.data.repository

import com.example.taxyrider.mviarchitecture.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
}