package com.example.ziririt.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    companion object {
        const val TAG = "MainViewModel"
    }

    private val _items = MutableLiveData<List<String>>()
    val items: LiveData<List<String>> get() = _items

    fun setItems(strings: List<String>) {
        _items.value = strings
    }
}
