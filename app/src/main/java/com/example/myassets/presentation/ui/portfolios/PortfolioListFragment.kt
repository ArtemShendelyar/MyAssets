package com.example.myassets.presentation.ui.portfolios

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myassets.databinding.FragmentPortfolioListBinding
import com.example.myassets.presentation.util.BasicFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PortfolioListFragment : BasicFragment<FragmentPortfolioListBinding>() {
    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentPortfolioListBinding.inflate(inflater, container, false)
}
