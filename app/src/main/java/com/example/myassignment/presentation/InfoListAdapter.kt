package com.example.myassignment.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myassignment.R
import com.example.myassignment.databinding.ItemInfoBinding
import com.example.myassignment.model.Info

class InfoListAdapter : RecyclerView.Adapter<InfoListAdapter.ViewHolder>() {
    private lateinit var infoList: List<Info>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemInfoBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_info, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(infoList[position])
    }

    override fun getItemCount(): Int {
        return if (::infoList.isInitialized) infoList.size else 0
    }

    fun updateInfoList(infoList: List<Info>) {
        this.infoList = infoList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemInfoBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = InfoViewModel()

        fun bind(info: Info) {
            viewModel.bind(info)
            binding.viewModel = viewModel
        }
    }
}