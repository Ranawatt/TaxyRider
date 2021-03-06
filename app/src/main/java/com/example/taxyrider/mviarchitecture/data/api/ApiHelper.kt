package com.example.taxyrider.mviarchitecture.data.api

import com.example.taxyrider.mviarchitecture.data.model.User
import retrofit2.http.GET

interface ApiHelper {

    suspend fun getUsers(): List<User>
}