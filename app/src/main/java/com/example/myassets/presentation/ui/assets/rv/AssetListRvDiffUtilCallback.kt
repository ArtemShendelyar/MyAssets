package com.example.myassets.presentation.ui.assets.rv

import androidx.recyclerview.widget.DiffUtil
import domain.entity.PortfolioItem

class AssetListRvDiffUtilCallback (
    private val oldList: List<PortfolioItem>,
    private val newList: List<PortfolioItem>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}