package com.example.myassets.presentation.ui.portfolios.rv

import androidx.recyclerview.widget.DiffUtil
import domain.entity.Portfolio

class PortfolioListRvDiffUtilCallback(
    private val oldList: List<Portfolio>,
    private val newList: List<Portfolio>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}
