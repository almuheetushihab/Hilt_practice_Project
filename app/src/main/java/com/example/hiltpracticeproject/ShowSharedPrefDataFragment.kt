package com.example.hiltpracticeproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.hiltpracticeproject.databinding.FragmentShowsharedPrefDataBinding
import com.example.hiltpracticeproject.reposatories.EmployeeRepository
import com.example.hiltpracticeproject.viewModel.EmployeeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowSharedPrefDataFragment : Fragment() {
    private lateinit var binding: FragmentShowsharedPrefDataBinding
    private val viewModel: EmployeeViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowsharedPrefDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getEmployee()
        viewModel.items.observe(viewLifecycleOwner) {
            it?.let {
//                val employeeName = viewModel.getEmployeeName()
//                binding.sharedPrefData.text = employeeName
            }
        }

    }


}