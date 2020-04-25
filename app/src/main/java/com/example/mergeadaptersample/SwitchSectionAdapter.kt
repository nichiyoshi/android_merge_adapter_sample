package com.example.mergeadaptersample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mergeadaptersample.databinding.ItemSectionSwitchBinding
import com.example.mergeadaptersample.databinding.ItemSectionTextBinding


class SwitchSectionAdapter: ListAdapter<SwitchItem, SwitchSectionViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SwitchItem>() {

            override fun areContentsTheSame(
                oldItem: SwitchItem,
                newItem: SwitchItem
            ): Boolean {
                android.util.Log.d("SwitchSectionAdapter", "ItemCallback")
                return oldItem == newItem
            }

            override fun areItemsTheSame(
                oldItem: SwitchItem,
                newItem: SwitchItem
            ) = oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwitchSectionViewHolder {
        val binding = ItemSectionSwitchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SwitchSectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SwitchSectionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}

class SwitchSectionViewHolder(private val binding: ItemSectionSwitchBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: SwitchItem) {
        binding.switch1.isChecked = item.isChecked
    }
}

data class SwitchItem(
    val id: Int,
    val isChecked: Boolean)