package com.example.myassets.presentation.ui.assets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.myassets.databinding.FragmentAssetListBinding
import com.example.myassets.presentation.ui.assets.rv.AssetListRvAdapter
import com.example.myassets.presentation.util.BasicFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AssetListFragment : BasicFragment<FragmentAssetListBinding>() {
    private val viewModel: AssetListViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAssetListBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AssetListRvAdapter()
        binding.assetListRv.adapter = adapter

        viewModel.portfolioItemsList.observe(viewLifecycleOwner) { portfolioList ->
            adapter.submit(portfolioList)
        }
    }
}
