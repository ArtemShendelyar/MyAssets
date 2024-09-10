package presentation.ui.portfolios.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.myassets.databinding.PortfolioRvCardBinding
import presentation.ui.portfolios.rv.listeners.PortfolioListItemListener
import domain.entity.Portfolio

class PortfolioListRvViewHolder(
    private val binding: PortfolioRvCardBinding,
    private val itemListener: PortfolioListItemListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(portfolio: Portfolio) {
        binding.portfolioName.text = portfolio.name
        itemView.setOnClickListener {
            itemListener.onItemClick(portfolio.id)
        }
        binding.portfolioSelectBtn.setOnClickListener {
            itemListener.onSelect(portfolio.id)
        }
    }
}
