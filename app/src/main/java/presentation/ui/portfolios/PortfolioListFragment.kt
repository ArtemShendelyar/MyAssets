package presentation.ui.portfolios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myassets.R
import dagger.hilt.android.AndroidEntryPoint
import domain.entity.Portfolio

@AndroidEntryPoint
class PortfolioListFragment : Fragment() {
    private val viewModel: PortfolioListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                PortfolioListScreen()
            }
        }
    }

    @Composable
    fun PortfolioListScreen() {
        val portfolioList by viewModel.portfolioList.observeAsState()
        PortfolioListContent(
            portfolioList,
            onCreateClick = {
                viewModel.createPortfolio(resources.getString(R.string.new_portfolio))
            }
        )
    }

    @Composable
    fun PortfolioListContent(
        portfolioList: List<Portfolio>?,
        onCreateClick: () -> Unit
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.portfolio_list_label),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                )
                Image(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = stringResource(id = R.string.new_portfolio_button),
                    modifier = Modifier
                        .size(28.dp)
                        .align(Alignment.TopEnd)
                        .clickable(onClick = onCreateClick)
                )
            }
            if (!portfolioList.isNullOrEmpty()) {
                LazyColumn(
                    Modifier
                        .fillMaxSize()
                        .padding(top = 8.dp)
                ) {
                    items(portfolioList) {
                        PortfolioCard(it)
                    }
                }
            }
        }
    }

    @Composable
    fun PortfolioCard(
        portfolio: Portfolio
    ) {
        Card(
            modifier = Modifier
                .clickable(
                    onClick = {
                        findNavController().navigate(
                            PortfolioListFragmentDirections.actionToPortfolioDetailsFragment(
                                portfolio.id
                            )
                        )
                    }
                )
                .padding(top = 6.dp, bottom = 6.dp),
            shape = MaterialTheme.shapes.small,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(
                    text = portfolio.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                )
                Button(
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    onClick = {
                        TODO("Реализация переключения портфеля")
                    }
                ) {
                    Text(stringResource(R.string.portfolio_select))
                }
            }
        }
    }
}
