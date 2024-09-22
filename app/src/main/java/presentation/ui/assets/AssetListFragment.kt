package presentation.ui.assets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myassets.R
import dagger.hilt.android.AndroidEntryPoint
import domain.entity.PortfolioItem

@AndroidEntryPoint
class AssetListFragment : Fragment() {
    private val viewModel: AssetListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AssetListScreen()
            }
        }
    }
    @Composable
    fun AssetListScreen() {
        val portfolioItemsList by viewModel.portfolioItemsList.observeAsState()
        PortfolioItemListContent(
            portfolioItemsList
        )
    }
    @Composable
    fun PortfolioItemListContent(
        portfolioItemsList: List<PortfolioItem>?,
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
                    text = stringResource(id = R.string.label_of_assets),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                )
            }
            if (!portfolioItemsList.isNullOrEmpty()) {
                LazyColumn(
                    Modifier
                        .fillMaxSize()
                        .padding(top = 8.dp)
                ) {
                    items(portfolioItemsList) {
                        PortfolioItemCard(it)
                    }
                }
            }
        }
    }

    @Composable
    fun PortfolioItemCard(
        portfolioItem: PortfolioItem
    ) {
        Card(
            modifier = Modifier
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
                    text = portfolioItem.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                )
            }
        }
    }
}
