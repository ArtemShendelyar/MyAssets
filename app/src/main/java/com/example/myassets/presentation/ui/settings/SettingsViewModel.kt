package com.example.myassets.presentation.ui.settings

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.repository.DataStoreRepository
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val dataStoreRepository : DataStoreRepository
): ViewModel() {

    override fun onCleared() {

        super.onCleared()
    }



}