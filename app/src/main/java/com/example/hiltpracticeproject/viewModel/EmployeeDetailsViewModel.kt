package com.example.hiltpracticeproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltpracticeproject.model.EmployeeResponseItem
import com.example.hiltpracticeproject.reposatories.EmployeeDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class   EmployeeDetailsViewModel @Inject constructor(val employeeDetailsReposatories: EmployeeDetailsRepository) : ViewModel() {
    private val _items: MutableLiveData<EmployeeResponseItem?> by lazy {
        MutableLiveData<EmployeeResponseItem?>()
    }
    val items: LiveData<EmployeeResponseItem?> get() = _items

    fun getEmployeeDetails(id: Int) = viewModelScope.launch {
        try {
            _items.value = employeeDetailsReposatories.getEmployeeDetails(id)
        } catch (e: Exception) {
            _items.value = null
        }
    }
}