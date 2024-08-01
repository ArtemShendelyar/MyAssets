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
import domain.entity.Locales

class LanguageBottomSheetFragment: BasicBottomSheetFragment<FragmentBottomSheetListBinding>(){

    private val settingsViewModel: SettingsViewModel by viewModels({ requireParentFragment() })

    private var optionsList = Locales.entries.toTypedArray()
    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentBottomSheetListBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArrayAdapter(
            requireContext(), R.layout.item_bottom_sheet_list, optionsList
        )
        binding.bottomSheetList.adapter = adapter
        binding.bottomSheetList.setOnItemClickListener { _, _, position, _ ->
            settingsViewModel.saveAppLanguage(optionsList[position].localeName)
            dialog?.dismiss()
        }
    }
    companion object {
        const val TAG = "SelectLanguageDialog"
    }
}