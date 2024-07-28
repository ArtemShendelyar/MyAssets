package com.example.myassets.presentation.ui.portfolios.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myassets.databinding.PortfolioRvCardBinding
import domain.entity.Portfolio

class PortfolioListRvAdapter(
    private var items: List<Portfolio>,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<PortfolioListRvViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioListRvViewHolder {
        return PortfolioListRvViewHolder(
            PortfolioRvCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PortfolioListRvViewHolder, position: Int) {
        holder.bind(items[position], onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateAdapter(newItems: List<Portfolio>) {
        val diffUtilCallback = PortfolioListRvDiffUtilCallback(items, newItems)
        items = newItems
        DiffUtil.calculateDiff(diffUtilCallback).dispatchUpdatesTo(this)
    }
}
