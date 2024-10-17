package com.example.hiltpracticeproject

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.example.hiltpracticeproject.databinding.AdapterEmployeeBinding
import com.example.hiltpracticeproject.model.EmployeeResponseItem
import javax.inject.Inject


class EmployeeAdapter @Inject constructor(

) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    private lateinit var employeeList: ArrayList<EmployeeResponseItem>

    companion object {
        var listener: ItemClickListener? = null
    }

    class ViewHolder(var binding: AdapterEmployeeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            AdapterEmployeeBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val employee = employeeList[position]
        val imageUrl =
            "https://plus.unsplash.com/premium_photo-1664536392896-cd1743f9c02c?q=80&w=320"
        Glide.with(viewHolder.itemView.context)
            .load(imageUrl)
            .circleCrop()
            .into(viewHolder.binding.ivEmployeeImg)

        viewHolder.binding.tvEmployeeName.text = employee.name
        viewHolder.binding.ivEmployeeNum.text = employee.phone
        viewHolder.itemView.setOnClickListener {
            listener?.onItemClick(employee.id)
        }
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    interface ItemClickListener {
        fun onItemClick(id: Int)
    }

    fun setEmployeeList(list: ArrayList<EmployeeResponseItem>) {
        this.employeeList = list
    }


}