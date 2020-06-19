package com.example.taxyrider.mviarchitecture.data.api

import com.example.taxyrider.mviarchitecture.data.model.User
import retrofit2.http.GET

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }
}