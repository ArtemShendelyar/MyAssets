package presentation.ui.portfolios

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myassets.R
import dagger.hilt.android.AndroidEntryPoint
import domain.entity.Portfolio

@AndroidEntryPoint
class PortfolioDetailsFragment : Fragment() {
    private val viewModel: PortfolioDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val args: PortfolioDetailsFragmentArgs by navArgs()
        val portfolioId = args.portfolioId
        viewModel.fetchPortfolioById(portfolioId)

        viewModel.error.observe(viewLifecycleOwner) { error ->
            error?.let {
                Toast.makeText(
                    context,
                    getString(R.string.error) + it,
                    Toast.LENGTH_SHORT
                ).show()
                viewModel.resetError()
                findNavController().navigateUp()
            }
        }

        return ComposeView(requireContext()).apply {
            setContent {
                DetailsScreen()
            }
        }
    }

    @Composable
    fun DetailsScreen() {
        var newName by rememberSaveable { mutableStateOf("") }
        val portfolio by viewModel.portfolio.observeAsState()
        DetailsContent(
            portfolio,
            newName,
            onRenameClick = {
                portfolio?.let { viewModel.renamePortfolio(it.id, newName) }
            },
            onDeleteClick = {
                portfolio?.let {
                    val dialogClickListener =
                        DialogInterface.OnClickListener { dialog, which ->
                            when (which) {
                                DialogInterface.BUTTON_POSITIVE -> {
                                    viewModel.deletePortfolio(it.id)
                                    findNavController().navigateUp()
                                }
                            }
                        }
                    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
                    builder.setMessage(R.string.portfolio_delete_confirmation)
                        .setPositiveButton(
                            R.string.portfolio_delete_confirmation_yes,
                            dialogClickListener
                        )
                        .setNegativeButton(R.string.cancel, dialogClickListener)
                        .show()
                }
            },
            onBackClick = {
                findNavController().navigateUp()
            },
            onNameChange = {
                newName = it
            }
        )
    }

    @Composable
    fun DetailsContent(
        portfolio: Portfolio?,
        newName: String,
        onRenameClick: () -> Unit,
        onDeleteClick: () -> Unit,
        onBackClick: () -> Unit,
        onNameChange: (String) -> Unit
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = stringResource(id = R.string.back),
                    modifier = Modifier
                        .clickable(onClick = onBackClick)
                        .padding(end = 8.dp)
                )
                Text(
                    text = portfolio?.name ?: stringResource(id = R.string.loading),
                    fontSize = 24.sp
                )
            }
            OutlinedTextField(
                value = newName,
                onValueChange = onNameChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                label = { Text(stringResource(R.string.new_name)) }
            )
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = onRenameClick,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {
                    Text(stringResource(R.string.rename))
                }
                Button(
                    onClick = onDeleteClick,
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(stringResource(R.string.portfolio_delete))
                }
            }
        }
    }
}
