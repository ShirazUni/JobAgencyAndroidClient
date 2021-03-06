package com.example.findyourapplication

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class HomeViewModelFactory(private val context: Context) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeRecyclerItemViewModel::class.java)){
            return HomeRecyclerItemViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}