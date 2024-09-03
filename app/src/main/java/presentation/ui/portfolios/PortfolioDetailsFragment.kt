package presentation.ui.portfolios

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myassets.R
import com.example.myassets.databinding.FragmentPortfolioDetailsBinding
import presentation.util.BasicFragment
import dagger.hilt.android.AndroidEntryPoint
import domain.entity.Portfolio

@AndroidEntryPoint
class PortfolioDetailsFragment : BasicFragment<FragmentPortfolioDetailsBinding>() {
    private val viewModel: PortfolioDetailsViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentPortfolioDetailsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: presentation.ui.portfolios.PortfolioDetailsFragmentArgs by navArgs()
        val portfolioId = args.portfolioId
        viewModel.fetchPortfolioById(portfolioId)

        viewModel.portfolio.observe(viewLifecycleOwner) { portfolio ->
            bindPortfolio(portfolio)
        }

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.renameButton.setOnClickListener {
            viewModel.renamePortfolio(portfolioId, binding.renameEditText.text.toString())
        }

        binding.deleteButton.setOnClickListener {
            val dialogClickListener =
                DialogInterface.OnClickListener { dialog, which ->
                    when (which) {
                        DialogInterface.BUTTON_POSITIVE -> {
                            viewModel.deletePortfolio(portfolioId)
                            findNavController().navigateUp()
                        }
                    }
                }
            val builder: AlertDialog.Builder = AlertDialog.Builder(context)
            builder.setMessage(resources.getString(R.string.portfolio_delete_confirmation))
                .setPositiveButton(
                    resources.getString(R.string.portfolio_delete_confirmation_yes),
                    dialogClickListener
                )
                .setNegativeButton(resources.getString(R.string.cancel), dialogClickListener)
                .show()
        }

        viewModel.error.observe(
            viewLifecycleOwner
        ) { error ->
            error?.let {
                Toast.makeText(
                    context,
                    resources.getString(R.string.error) + error,
                    Toast.LENGTH_SHORT
                )
                    .show()
                viewModel.resetError()
                findNavController().navigateUp()
            }
        }
    }

    private fun bindPortfolio(portfolio: Portfolio?) {
        with(binding) {
            label.text = portfolio?.name ?: resources.getString(R.string.loading)
            renameEditText.setText(portfolio?.name ?: resources.getString(R.string.loading))
        }
    }
}
