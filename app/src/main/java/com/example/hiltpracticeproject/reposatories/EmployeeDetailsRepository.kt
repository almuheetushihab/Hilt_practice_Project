package com.example.hiltpracticeproject.reposatories

import com.example.hiltpracticeproject.model.EmployeeResponseItem
import com.example.hiltpracticeproject.networks.ApiClient
import com.example.hiltpracticeproject.networks.ApiInterface
import javax.inject.Inject

class EmployeeDetailsRepository @Inject constructor() {
    suspend fun getEmployeeDetails(id: Int): EmployeeResponseItem?{
        val employeeApi = ApiClient.getInstance().create(ApiInterface::class.java)
        return employeeApi.getEmployeeDetails(id).body()
    }

}