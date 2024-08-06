package com.example.myassets.presentation.ui.portfolios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.myassets.databinding.FragmentPortfolioListBinding
import com.example.myassets.presentation.ui.portfolios.rv.PortfolioListRvAdapter
import com.example.myassets.presentation.ui.portfolios.rv.listeners.PortfolioListItemListener
import com.example.myassets.presentation.util.BasicFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PortfolioListFragment : BasicFragment<FragmentPortfolioListBinding>() {
    private val viewModel: PortfolioListViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentPortfolioListBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PortfolioListRvAdapter(itemListener = object : PortfolioListItemListener {
            override fun onItemClick(itemId: Int) {
                TODO("Реализация перехода на детальный экран")
            }

            override fun onSelect(itemId: Int) {
                TODO("Реализация переключения портфеля")
            }
        }
        )
        binding.portfolioListRv.adapter = adapter

        viewModel.portfolioList.observe(viewLifecycleOwner) { portfolioList ->
            adapter.submitList(portfolioList)
        }

        binding.createPortfolioButton.setOnClickListener {
            viewModel.createPortfolio()
            adapter.notifyDataSetChanged()
        }
    }
}
