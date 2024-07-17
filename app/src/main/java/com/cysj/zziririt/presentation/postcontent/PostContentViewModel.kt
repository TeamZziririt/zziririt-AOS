package com.cysj.zziririt.presentation.postcontent

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostContentViewModel @Inject constructor(

) : ViewModel() {
    companion object {
        const val TAG = "PostContentViewModel"
    }
}
