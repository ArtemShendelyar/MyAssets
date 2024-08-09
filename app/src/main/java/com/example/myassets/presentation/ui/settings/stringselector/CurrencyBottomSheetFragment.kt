package com.example.myassets.presentation.ui.settings.stringselector

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.example.myassets.databinding.FragmentBottomSheetListBinding
import com.example.myassets.presentation.ui.settings.stringselector.rv.BottomSheetAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CurrencyBottomSheetFragment : BottomSheetDialogFragment() {
    companion object {
        const val KEY_CURRENCY = "currencyKey"
        const val KEY_CURRENCY_NAME = "currencyName"
    }
    private var _binding: FragmentBottomSheetListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomSheetListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BottomSheetAdapter()

        adapter.onClick = { currency ->
            setFragmentResult(KEY_CURRENCY, bundleOf(KEY_CURRENCY_NAME to currency.currencyName))
            dismiss()
        }
        binding.recyclerBottomSheet.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
