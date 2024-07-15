package com.example.myassets.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myassets.databinding.FragmentHomeBinding
import com.example.myassets.presentation.util.BasicFragment

class HomeFragment : BasicFragment<FragmentHomeBinding>() {
    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)
}
