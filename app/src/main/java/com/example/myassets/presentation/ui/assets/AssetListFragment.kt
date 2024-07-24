package com.example.myassets.presentation.ui.assets

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myassets.databinding.FragmentAssetListBinding
import com.example.myassets.presentation.util.BasicFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AssetListFragment : BasicFragment<FragmentAssetListBinding>() {
    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAssetListBinding.inflate(inflater, container, false)
}
