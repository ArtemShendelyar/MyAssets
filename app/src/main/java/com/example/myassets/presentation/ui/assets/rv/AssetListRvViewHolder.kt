package com.example.myassets.presentation.ui.assets.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.myassets.databinding.AssetListRvCardBinding
import domain.entity.PortfolioItem

class AssetListRvViewHolder (
    private val binding: AssetListRvCardBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(portfolioItem: PortfolioItem) {
        binding.assetName.text = portfolioItem.name
        itemView.setOnClickListener {
            TODO("Реализация переключения на детальный экран")
        }
    }
}