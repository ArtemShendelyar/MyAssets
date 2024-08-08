package com.example.myassets.presentation.ui.settings.stringselector.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.myassets.databinding.ItemBottomSheetListBinding
import domain.entity.Currencies

class BottomSheetViewHolder(
    private val binding: ItemBottomSheetListBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(retrievingItem: Currencies, onClick: (Currencies) -> Unit) {
        with(binding) {
            itemBottomSheetList.text = retrievingItem.currencyName
            root.setOnClickListener {
                onClick(retrievingItem)
            }
        }
    }
}
