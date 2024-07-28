package com.example.myassets.presentation.ui.portfolios.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.myassets.databinding.PortfolioRvCardBinding
import domain.entity.Portfolio

class PortfolioListRvViewHolder(
    private val binding: PortfolioRvCardBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(portfolio: Portfolio, onClick: (Int) -> Unit) {
        binding.portfolioName.text = portfolio.name
        itemView.setOnClickListener {
            onClick(portfolio.id)
        }
        binding.portfolioSelectBtn.setOnClickListener {
            TODO("Реализовать функционал переключения портфеля")
        }
    }
}
