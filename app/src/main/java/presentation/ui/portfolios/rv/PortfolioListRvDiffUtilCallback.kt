package presentation.ui.portfolios.rv

import androidx.recyclerview.widget.DiffUtil
import domain.entity.Portfolio

class PortfolioListRvDiffUtilCallback : DiffUtil.ItemCallback<Portfolio>() {

    override fun areItemsTheSame(oldItem: Portfolio, newItem: Portfolio): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Portfolio, newItem: Portfolio): Boolean =
        oldItem == newItem
}
