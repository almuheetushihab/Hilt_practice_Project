package com.example.hiltpracticeproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.hiltpracticeproject.databinding.FragmentEmployeeDetailsBinding
import com.example.hiltpracticeproject.databinding.FragmentEmployeeListBinding
import com.example.hiltpracticeproject.reposatories.EmployeeDetailsRepository
import com.example.hiltpracticeproject.viewModel.EmployeeDetailsViewModel
import com.example.hiltpracticeproject.viewModel.EmployeeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmployeeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentEmployeeDetailsBinding
    private val viewModel: EmployeeDetailsViewModel by viewModels()
    private val args: EmployeeDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmployeeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = args.data
        Log.d("Log404", "onViewCreated: $id")
        viewModel.getEmployeeDetails(id)
        viewModel.items.observe(viewLifecycleOwner) {
            it?.let {
                val imageUrl =
                    "https://plus.unsplash.com/premium_photo-1664536392896-cd1743f9c02c?q=80&w=320"
                Glide.with(requireContext())
                    .load(imageUrl)
                    .circleCrop()
                    .into(binding.ivEmployeeProfileImg)

                binding.tvEmployeeName.text = it.name
                binding.tvEmployeeEmail.text = it.email
                binding.tvEmployeeUserName.text = it.username
                binding.tvEmployeeStreet.text = it.address.street
                binding.tvEmployeeSuite.text = it.address.suite
                binding.tvEmployeeCity.text = it.address.city
                binding.tvEmployeeZipcode.text = it.address.zipcode
                binding.tvEmployeeLat.text = it.address.geo.lat
                binding.tvEmployeeLng.text = it.address.geo.lng
                binding.tvEmployeePhone.text = it.phone
                binding.tvEmployeeWebsite.text = it.website
                binding.tvEmployeeCompanyBs.text = it.company.bs
                binding.tvEmployeeCatchPhrase.text = it.company.catchPhrase
                binding.tvEmployeeCompanyName.text = it.company.name
                binding.tvEmployeeId.text = it.id.toString()

            }
        }

    }
}