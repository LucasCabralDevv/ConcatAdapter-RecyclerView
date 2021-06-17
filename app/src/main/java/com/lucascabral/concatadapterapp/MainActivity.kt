package com.lucascabral.concatadapterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucascabral.concatadapterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}