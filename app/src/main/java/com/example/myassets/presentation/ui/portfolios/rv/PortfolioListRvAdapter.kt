package com.example.myassets.presentation.ui.portfolios.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.myassets.databinding.PortfolioRvCardBinding
import com.example.myassets.presentation.ui.portfolios.rv.listeners.PortfolioListItemListener
import domain.entity.Portfolio

class PortfolioListRvAdapter(
    private val itemListener: PortfolioListItemListener
) : ListAdapter<Portfolio, PortfolioListRvViewHolder>(PortfolioListRvDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioListRvViewHolder {
        return PortfolioListRvViewHolder(
            PortfolioRvCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            itemListener
        )
    }

    override fun onBindViewHolder(holder: PortfolioListRvViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
