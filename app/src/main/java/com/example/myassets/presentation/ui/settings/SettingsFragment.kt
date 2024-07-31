package com.example.myassets.presentation.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.myassets.databinding.FragmentSettingsBinding
import com.example.myassets.presentation.ui.settings.stringselector.CurrencyBottomSheetFragment
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
        settingsViewModel.defaultCurrency.observe(viewLifecycleOwner) {
            binding.currencyValue.text = it
        }

        binding.settingsCurrency.setOnClickListener {
            CurrencyBottomSheetFragment().show(
                childFragmentManager, CurrencyBottomSheetFragment.TAG
            )
        }
    }
}
