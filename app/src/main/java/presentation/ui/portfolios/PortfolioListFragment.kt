package presentation.ui.portfolios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myassets.R
import com.example.myassets.databinding.FragmentPortfolioListBinding
import presentation.ui.portfolios.rv.PortfolioListRvAdapter
import presentation.ui.portfolios.rv.listeners.PortfolioListItemListener
import presentation.util.BasicFragment
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
                findNavController().navigate(
                    presentation.ui.portfolios.PortfolioListFragmentDirections.actionToPortfolioDetailsFragment(
                        itemId
                    )
                )
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
            viewModel.createPortfolio(resources.getString(R.string.new_portfolio))
        }
    }
}
