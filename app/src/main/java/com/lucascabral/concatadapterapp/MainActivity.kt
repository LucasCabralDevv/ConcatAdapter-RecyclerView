package com.lucascabral.concatadapterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ConcatAdapter
import com.lucascabral.concatadapterapp.adapter.ProgrammingLanguagesAdapter
import com.lucascabral.concatadapterapp.adapter.TipsAdapter
import com.lucascabral.concatadapterapp.databinding.ActivityMainBinding
import com.lucascabral.concatadapterapp.model.programmingLanguages
import com.lucascabral.concatadapterapp.model.tips

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var programmingLanguagesAdapter: ProgrammingLanguagesAdapter
    private lateinit var tipsAdapter: TipsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        programmingLanguagesAdapter = ProgrammingLanguagesAdapter()
        tipsAdapter = TipsAdapter().apply {
            gotItItemClickListener = {
                dismissTip()
            }
        }
        binding.mainRecyclerView.adapter = ConcatAdapter(tipsAdapter, programmingLanguagesAdapter)

        tipsAdapter.submitList(tips)
        programmingLanguagesAdapter.submitList(programmingLanguages)
    }

    private fun dismissTip() {
        tipsAdapter.notifyItemRemoved(0)
    }
}