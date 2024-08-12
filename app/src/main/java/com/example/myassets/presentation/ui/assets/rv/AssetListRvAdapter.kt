package com.example.myassets.presentation.ui.assets.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myassets.databinding.AssetListRvCardBinding
import domain.entity.PortfolioItem


class AssetListRvAdapter : RecyclerView.Adapter<AssetListRvViewHolder>() {
    private var items = emptyList<PortfolioItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetListRvViewHolder {
        return AssetListRvViewHolder(
            AssetListRvCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun submit(newItems: List<PortfolioItem>) {
        val diffUtilCallback = AssetListRvDiffUtilCallback(items, newItems)
        items = newItems
        DiffUtil.calculateDiff(diffUtilCallback).dispatchUpdatesTo(this)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: AssetListRvViewHolder, position: Int) {
        holder.bind(items[position])
    }
}