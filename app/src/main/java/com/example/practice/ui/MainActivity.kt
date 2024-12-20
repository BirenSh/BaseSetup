package com.example.practice.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.OnReceiveContentViewBehavior
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice.R
import com.example.practice.databinding.ActivityMainBinding
import com.example.practice.ui.adapters.QuoteAdapter
import com.example.practice.view_modules.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.Objects

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private val quoteAdapter = QuoteAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.recyclerView1.layoutManager = LinearLayoutManager(this)
        binding.recyclerView1.adapter = quoteAdapter

        lifecycleScope.launch {
            mainViewModel.getListOfQuote()
        }

        mainViewModel.listOfQuote.observe(this){
            if (!Objects.isNull(it)){
                println("=====it: ${it[0]}")
                quoteAdapter.fetchQuoteList(it)
            }
        }




    }
}