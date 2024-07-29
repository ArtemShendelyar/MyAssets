package com.example.myassets.presentation.ui.portfolios.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.myassets.databinding.PortfolioRvCardBinding
import com.example.myassets.presentation.ui.portfolios.rv.listeners.PortfolioListItemListenerImpl
import domain.entity.Portfolio

class PortfolioListRvViewHolder(
    private val binding: PortfolioRvCardBinding,
    private val itemListenerImpl: PortfolioListItemListenerImpl
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(portfolio: Portfolio) {
        binding.portfolioName.text = portfolio.name
        itemView.setOnClickListener {
            itemListenerImpl.onItemClick(portfolio.id)
        }
        binding.portfolioSelectBtn.setOnClickListener {
            itemListenerImpl.onSelect(portfolio.id)
        }
    }
}
