package com.lucascabral.concatadapterapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lucascabral.concatadapterapp.adapter.ProgrammingLanguagesAdapter.*
import com.lucascabral.concatadapterapp.databinding.ItemProgrammingLanguageBinding
import com.lucascabral.concatadapterapp.model.ProgrammingLanguage

class ProgrammingLanguagesAdapter
    : ListAdapter<ProgrammingLanguage, ProgrammingLanguagesViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProgrammingLanguagesViewHolder {
        return ProgrammingLanguagesViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ProgrammingLanguagesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ProgrammingLanguage>() {
            override fun areItemsTheSame(
                oldItem: ProgrammingLanguage,
                newItem: ProgrammingLanguage
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: ProgrammingLanguage,
                newItem: ProgrammingLanguage
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    class ProgrammingLanguagesViewHolder(
        private val binding: ItemProgrammingLanguageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(language: ProgrammingLanguage) {
            binding.run {
                textLanguageName.text = language.name
                textParadigm.text = language.paradigm
                imageLanguage.setImageResource(language.logo)
            }
        }

        companion object {
            fun create(parent: ViewGroup): ProgrammingLanguagesViewHolder {
                val binding = ItemProgrammingLanguageBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                return ProgrammingLanguagesViewHolder(binding)
            }
        }
    }
}