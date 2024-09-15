package presentation.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myassets.R
import dagger.hilt.android.AndroidEntryPoint
import domain.entity.Currencies

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private val settingsViewModel: SettingsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                SettingsScreen()
            }
        }
    }

    @Composable
    fun SettingsScreen() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
        ) {
            Text(
                text = stringResource(id = R.string.settings_name),
                overflow = TextOverflow.Visible,
                maxLines = 1,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
            )
            val globalCurrency by settingsViewModel.currentCurrency.observeAsState(initial = "BugInSettingsVM")
            CurrencyDropDownMenu(cardText = stringResource(id = R.string.currency), globalCurrency)
        }
    }

    @Composable
    fun CurrencyDropDownMenu(
        cardText: String = "SettingStroke", settingDropDownText: String = "DropDownList"
    ) {
        Card(
            modifier = Modifier
                .padding(top = 3.dp, bottom = 3.dp),
            shape = MaterialTheme.shapes.small,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            )
        ) {
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .padding(15.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = cardText,
                        overflow = TextOverflow.Visible,
                        maxLines = 1,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                    )

                    val isDropDownExpanded = remember {
                        mutableStateOf(false)
                    }
                    val usernames = Currencies.entries.toList()
                    Row(
                        modifier = Modifier.clickable {
                            isDropDownExpanded.value = true
                        }
                    ) {
                        Text(
                            text = settingDropDownText,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                        )
                        Image(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "DropDown Icon"
                        )
                        DropdownMenu(
                            expanded = isDropDownExpanded.value,
                            onDismissRequest = {
                                isDropDownExpanded.value = false
                            }) {
                            usernames.forEach { username ->
                                DropdownMenuItem(
                                    text = {
                                        Text(text = username.currencyName)
                                    },
                                    onClick = {
                                        settingsViewModel.saveGlobalCurrency(username.currencyName)
                                        isDropDownExpanded.value = false
                                    })
                            }
                        }
                    }
                }
            }
        }
    }
}
