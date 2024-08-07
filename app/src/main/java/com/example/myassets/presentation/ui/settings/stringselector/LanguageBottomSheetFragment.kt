package com.example.myassets.presentation.ui.settings.stringselector

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.example.myassets.R
import com.example.myassets.databinding.FragmentBottomSheetListBinding
import com.example.myassets.presentation.ui.settings.SettingsViewModel
import com.example.myassets.presentation.util.BasicBottomSheetFragment

class LanguageBottomSheetFragment : BasicBottomSheetFragment<FragmentBottomSheetListBinding>() {

    private val settingsViewModel: SettingsViewModel by viewModels({ requireParentFragment() })

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentBottomSheetListBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Костыль.
        val optionsListUI = getString(R.string.locales_for_UI).split(",")
        val optionsList = getString(R.string.locales).split(",")
        val adapter = ArrayAdapter(
            requireContext(), R.layout.item_bottom_sheet_list, optionsListUI
        )
        binding.bottomSheetList.adapter = adapter
        binding.bottomSheetList.setOnItemClickListener { _, _, position, _ ->
            settingsViewModel.saveAppLanguage(optionsList[position], optionsListUI[position])
            dialog?.dismiss()
        }
    }

    companion object {
        const val TAG = "SelectLanguageDialog"
    }
}
