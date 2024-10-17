package com.example.hiltpracticeproject.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltpracticeproject.model.EmployeeResponse
import com.example.hiltpracticeproject.reposatories.EmployeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor(val employeeRepository: EmployeeRepository,
    ) : ViewModel() {
    private val _items: MutableLiveData<EmployeeResponse?> by lazy {
        MutableLiveData<EmployeeResponse?>()
    }
    val items: LiveData<EmployeeResponse?> get() = _items

    fun getEmployee() = viewModelScope.launch {
        try {
            _items.value = employeeRepository.getEmployee()

            Log.d("TAG", "getEmployee: ${_items.value}")

        } catch (e: Exception) {
            _items.value = null
        }
    }
}

