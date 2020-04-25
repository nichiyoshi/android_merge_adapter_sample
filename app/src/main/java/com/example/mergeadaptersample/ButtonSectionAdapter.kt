package com.example.mergeadaptersample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mergeadaptersample.databinding.ItemSectionButtonBinding

class ButtonSectionAdapter(private val onClick: () -> Unit): RecyclerView.Adapter<ButtonSectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonSectionViewHolder {
        val binding = ItemSectionButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ButtonSectionViewHolder(binding)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: ButtonSectionViewHolder, position: Int) {
        holder.bind(onClick)
    }

}

class ButtonSectionViewHolder(private val binding: ItemSectionButtonBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(onClick: () -> Unit) {
        binding.button.setOnClickListener {
            onClick()
        }
    }
}