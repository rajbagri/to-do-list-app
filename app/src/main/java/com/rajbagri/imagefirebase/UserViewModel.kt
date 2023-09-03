package com.rajbagri.imagefirebase

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository
): ViewModel() {
    fun upsert(item: useritem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: useritem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getItemInfo() = repository.getItemInfo()
}