package com.example.myassets.presentation.ui.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myassets.databinding.FragmentSettingsBinding
import com.example.myassets.presentation.util.BasicFragment

class SettingsFragment : BasicFragment<FragmentSettingsBinding>() {
    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSettingsBinding.inflate(inflater, container, false)
}
