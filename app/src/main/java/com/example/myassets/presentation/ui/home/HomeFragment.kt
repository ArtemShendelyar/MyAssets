package com.example.myassets.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.myassets.databinding.FragmentHomeBinding
import com.example.myassets.presentation.util.BasicFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BasicFragment<FragmentHomeBinding>() {
    private val viewModel: HomeFragmentViewModel by viewModels()
    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.portfoliosCount.observe(viewLifecycleOwner) { count ->
            with(binding) {
                textPortfoliosCount.text = count.toString()
            }
        }
        viewModel.assetsCount.observe(viewLifecycleOwner) { count ->
            with(binding) {
                textAssetsCount.text = count.toString()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchStats()
    }
}
