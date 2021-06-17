package com.lucascabral.concatadapterapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lucascabral.concatadapterapp.databinding.ItemTipBinding
import com.lucascabral.concatadapterapp.model.Tip

class TipsAdapter : ListAdapter<Tip, TipsAdapter.TipsViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsViewHolder {
        return TipsViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: TipsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Tip>() {
            override fun areItemsTheSame(oldItem: Tip, newItem: Tip): Boolean {
                return oldItem.description == newItem.description
            }

            override fun areContentsTheSame(oldItem: Tip, newItem: Tip): Boolean {
                return oldItem == newItem
            }

        }
    }

    class TipsViewHolder(
        private val binding: ItemTipBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tip: Tip) {
            binding.run {
                textTip.text = tip.description
            }
        }

        companion object {
            fun create(parent: ViewGroup): TipsViewHolder {
                val binding = ItemTipBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                return TipsViewHolder(binding)
            }
        }
    }
}