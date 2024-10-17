package com.example.hiltpracticeproject.reposatories

import com.example.hiltpracticeproject.model.EmployeeResponse
import com.example.hiltpracticeproject.networks.ApiClient
import com.example.hiltpracticeproject.networks.ApiInterface
import javax.inject.Inject

class EmployeeRepository @Inject constructor() {
    suspend fun getEmployee(): EmployeeResponse?{
        val employeeApi = ApiClient.getInstance().create(ApiInterface::class.java)
        return employeeApi.getEmployee().body()
    }
}