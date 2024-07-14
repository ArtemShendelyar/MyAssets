package com.example.myassets.presentation.ui.portfolios

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myassets.databinding.FragmentProtfolioListBinding
import com.example.myassets.presentation.util.BasicFragment

class ProtfolioListFragment : BasicFragment<FragmentProtfolioListBinding>() {
    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentProtfolioListBinding.inflate(inflater, container, false)
}
