package com.example.mergeadaptersample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mergeadaptersample.databinding.ItemSectionTextBinding


class TextSectionAdapter: ListAdapter<TextItem, TextSectionViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TextItem>() {
            override fun areContentsTheSame(
                oldItem: TextItem,
                newItem: TextItem
            ): Boolean {
                android.util.Log.d("TextSectionAdapter", "onChanged")
                return oldItem == newItem
            }

            override fun areItemsTheSame(
                oldItem: TextItem,
                newItem: TextItem
            ) = oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextSectionViewHolder {
        val binding = ItemSectionTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TextSectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TextSectionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}

class TextSectionViewHolder(private val binding: ItemSectionTextBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: TextItem) {
        binding.textView.text = item.text
    }
}

data class TextItem(val id: Int, val text: String)