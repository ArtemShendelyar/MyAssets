package com.example.myassets.presentation.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myassets.databinding.FragmentSettingsBinding
import com.example.myassets.presentation.ui.settings.stringselector.CurrencyBottomSheetFragment.Companion.KEY_CURRENCY
import com.example.myassets.presentation.ui.settings.stringselector.CurrencyBottomSheetFragment.Companion.KEY_CURRENCY_NAME
import com.example.myassets.presentation.util.BasicFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BasicFragment<FragmentSettingsBinding>() {

    private val settingsViewModel: SettingsViewModel by viewModels()
    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSettingsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settingsViewModel.currentCurrency.observe(viewLifecycleOwner) {
            binding.currencyValue.text = it
        }

        setFragmentResultListener(KEY_CURRENCY) { _, bundle ->
            val result = bundle.getString(KEY_CURRENCY_NAME)
            if (result != null) {
                settingsViewModel.saveGlobalCurrency(result)
            }
        }

        binding.settingsCurrency.setOnClickListener {
            val action = SettingsFragmentDirections.letsCreateDialogForSelectingCurrency()
            findNavController().navigate(action)
        }
    }
}
