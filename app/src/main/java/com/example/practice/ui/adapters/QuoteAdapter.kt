package com.example.practice.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.databinding.QuoteItemsLayoutBinding
import com.example.practice.models.Quote
import com.example.practice.models.QuoteX

class QuoteAdapter:RecyclerView.Adapter<QuoteAdapter.MyViewHolder>() {
    private val listOfQuote = mutableListOf<QuoteX>()
    inner class MyViewHolder(private val binding: QuoteItemsLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bindData(quote: QuoteX){
            binding.quoteTv.text = quote.quote
            binding.authorTv.text = quote.author
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = QuoteItemsLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfQuote.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(listOfQuote[position])
    }

    fun fetchQuoteList(quotes:List<QuoteX>){
        listOfQuote.addAll(quotes)
        notifyDataSetChanged()
    }
}